package com.StuManageSystem.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.StringDAO;
import com.StuManageSystem.dao.Stu_scoreDAO;

/**
 * 查看单个学生成绩，同时提供查看未通过科目，分数段以上科目，平均分，只能修改，不能修改
 * @author Joe
 *
 */

public class AdminScoreSeek extends JDialog {

	private JTable coursetable; // 成绩表格
	private JScrollPane jsp; // 成绩滚动
	private Stu_scoreDAO scoredao; // 成绩操作
	private String stuid; // 学生学号id

	private JButton but_fail; // 未通过课程按钮
	private JButton but_all; // 查看所有课程按钮
	private JLabel lab_average; // 平均分，只用JLabel拼接显示

	// 分数段以上科目
	private JLabel lab_grade;
	private JTextField text_lowgrade;
	private JTextField text_highgrade;
	private JButton but_highgrade;
	private StringDAO stringdao;

	// 数据模型
	private DefaultTableModel t;

	public AdminScoreSeek(String stuid) {

		this.stuid = stuid;
		scoredao = new Stu_scoreDAO();
		stringdao = new StringDAO();
		String[] columns = { "学号", "姓名", "课程编号", "课程名称", "分数", "通过状态" };

		Vector columnsname = new Vector();
		columnsname.add("学号");
		columnsname.add("姓名");
		columnsname.add("课程编号");
		columnsname.add("课程名称");
		columnsname.add("分数");
		columnsname.add("通过状态");

		Vector data = scoredao.seekStuScore(stuid);

		t = new DefaultTableModel(columnsname, 0);// 使用数据模型构建JTable

		for (int i = 0; i < data.size(); i++) {
			t.addRow((Vector) data.get(i));
			if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
				t.setValueAt("通过", i, 5);
			} else {
				t.setValueAt("不通过", i, 5);
			}

		}

		// 表格实例化，加入滚动条中
		coursetable = new JTable();
		coursetable.setModel(t);
		coursetable.setRowHeight(26);
		coursetable.setEnabled(false);
		jsp = new JScrollPane(coursetable);
		jsp.setBounds(0, 0, 1100, 400);

		// 平均分,用string接收数据库的返回值，之后拼接在标签中，这个一直不变
		String average = scoredao.getAve(stuid);
		// System.out.println(average);
		lab_average = new JLabel("平均分:" + average);
		lab_average.setFont(new Font("微软雅黑", 0, 22));// 设置字体
		lab_average.setBounds(70, 450, 100, 50);

		// 未通过按键实例化,加到表格下方
		but_fail = new JButton("查看未通过课程");
		but_fail.setBounds(210, 450, 150, 50);
		// 查看所有成绩按钮
		but_all = new JButton("查看所有成绩");
		but_all.setBounds(210, 450, 150, 50);
		but_all.setVisible(false);

		// 分数段以上科目
		lab_grade = new JLabel("分数区间筛选：");
		lab_grade.setBounds(480, 450, 100, 50);

		text_lowgrade = new JTextField(10);
		JLabel div = new JLabel("~");

		div.setBounds(638, 450, 10, 50);
		text_lowgrade.setBounds(580, 450, 50, 50);
		text_highgrade = new JTextField(10);
		text_highgrade.setBounds(660, 450, 50, 50);
		but_highgrade = new JButton("查找");
		but_highgrade.setBounds(750, 450, 100, 50);

		// 点击未及格按钮，表格上刷出未及格的课程数据
		but_fail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);
				Vector data = scoredao.FindScoreFail(stuid);
				for (int i = 0; i < data.size(); i++) {
					t.addRow((Vector) data.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("通过", i, 5);
					} else {
						t.setValueAt("未通过", i, 5);
					}
				}
				but_all.setVisible(true);
				but_fail.setVisible(false);
			}
		});

		// 查看所有成绩监听事件
		but_all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);
				Vector data = scoredao.seekStuScore(stuid);
				for (int i = 0; i < data.size(); i++) {
					t.addRow((Vector) data.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("通过", i, 5);
					} else {
						t.setValueAt("未通过", i, 5);
					}
				}
				but_all.setVisible(false);
				but_fail.setVisible(true);
			}
		});

		// 点击查找安钮，等到输入框有字段，并且是符合成绩的，才开始进行查找，并且更新表格
		but_highgrade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setRowCount(0);

				int highgrade = 100;
				int lowgrade = 0;
				Vector betweendata = new Vector();
				// 添加验证,区间联合判断
				if (stringdao.isInteger(text_lowgrade.getText()) && stringdao.isInteger(text_highgrade.getText())
						&& !text_lowgrade.getText().equals("") && !text_highgrade.getText().equals("")) {
					// 判断是否是0~100的数字
					lowgrade = Integer.parseInt(text_lowgrade.getText());
					highgrade = Integer.parseInt(text_highgrade.getText());

					// 联合判断区间是否符合要求
					if ((lowgrade >= 0 && lowgrade <= 100)
							&& (highgrade >= 0 && highgrade <= 100 && highgrade >= lowgrade)) {
						betweendata = scoredao.FindMinAndMax(lowgrade, highgrade, stuid);
					} else {
						JOptionPane.showMessageDialog(null, "成绩输入格式有误，请检查区间是否输入正确");
					}

				} else {
					JOptionPane.showMessageDialog(null, "成绩输入格式有误，必须是数字");
				}

				// 设置表格数据
				for (int i = 0; i < betweendata.size(); i++) {
					t.addRow((Vector) betweendata.get(i));
					if (Integer.parseInt(t.getValueAt(i, 4).toString()) > 60) {
						t.setValueAt("通过", i, 5);
					} else {
						t.setValueAt("未通过", i, 5);
					}
				}

			}
		});

		// 成绩筛选输入框键盘事件
		text_highgrade.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent ke) {
				// 按下回车键查找成绩
				if (ke.getKeyCode() == 10) {
					but_highgrade.doClick();
				}
			}

			public void keyPressed(KeyEvent arg0) {
			}
		});

		this.add(lab_grade);
		this.add(text_lowgrade);
		this.add(div);
		this.add(text_highgrade);
		this.add(but_highgrade);
		this.add(lab_average);
		this.add(but_fail);
		this.add(but_all);
		this.add(jsp);
		this.setLayout(null);
		this.setSize(1100, 600);
		this.setTitle("管理员课程管理");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

	}

}
