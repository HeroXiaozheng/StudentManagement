package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.StuManageSystem.dao.AdminStudentDAO;
import com.StuManageSystem.dao.Stu_infoDAO;

/**
 * 学生查找界面，用于查找学生详细信息
 * @author Joe
 *
 */

public class AdminStudentSeek extends JPanel {

	private JLabel lab_seek;
	private JTextField text_seek;
	private JButton but_seek;
	private JPanel jp_seek;

	// 个人信息组件
	private JPanel jp_info;
	private JButton but_change;
	private JButton but_cancel;
	private JButton but_grade;
	private JPanel jp_but;
	private JScrollPane jsp_info;
	private JTable table;
	private JButton but_gradechange;
	private JButton but_gradelogin;

	private String stu_id;
	private Stu_infoDAO stuinfoDao;

	private AdminMainFrame adminMainFrame;

	public AdminStudentSeek(AdminMainFrame amf) {
		this.adminMainFrame = amf;

		stuinfoDao = new Stu_infoDAO();

		// 表格设置
		table = new JTable(11, 2);
		table.setValueAt("学号:", 0, 0);
		table.setValueAt("姓名:", 1, 0);
		table.setValueAt("性别:", 2, 0);
		table.setValueAt("出生日期:", 3, 0);
		table.setValueAt("省:", 4, 0);
		table.setValueAt("市:", 5, 0);
		table.setValueAt("地址:", 6, 0);
		table.setValueAt("院:", 7, 0);
		table.setValueAt("专业:", 8, 0);
		table.setValueAt("年级:", 9, 0);
		table.setValueAt("班级:", 10, 0);
		table.setEnabled(false);// 不可编辑
		
		table.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		//设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getTableHeader().setVisible(false);// 设置表头不显示
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // 设置表头（首选项）预选高度为0
		table.getTableHeader().setDefaultRenderer(renderer1);
		table.setRowHeight(60);
		// DefaultTableModel tableModel = new DefaultTableModel();

		// 加入滚动条
//		jsp_info = new JScrollPane(table);
		jp_info = new JPanel(new BorderLayout());
//		jp_info.setBounds(100, 0, 800, 350);
		jp_info.add(new JScrollPane(table));
		jp_info.setBounds(150, 100, 800, 300);

		jp_seek = new JPanel(new FlowLayout());
		
		text_seek = new JTextField(20);
		
		but_seek = new JButton("查找");
		
		jp_seek.add(text_seek);
		jp_seek.add(but_seek);
		jp_seek.setBounds(350, 50, 400, 100);
		
		// 按钮
		but_change = new JButton("修改");
		but_change.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_change.setBounds(200, 450, 100, 40);

		but_cancel = new JButton("注销");
		but_cancel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_cancel.setBounds(350, 450, 100, 40);

		but_grade = new JButton("查看成绩");
		but_grade.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_grade.setBounds(500, 450, 100, 40);

		but_gradechange = new JButton("修改成绩");
		but_gradechange.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_gradechange.setBounds(650, 450, 100, 40);

		but_gradelogin = new JButton("录入成绩");
		but_gradelogin.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_gradelogin.setBounds(800, 450, 100, 40);

		// 查找学号点击事件
		but_seek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String stu_id = text_seek.getText();

				AdminStudentDAO stuDao = new AdminStudentDAO();
				Vector data = stuDao.seekStudent(stu_id);

				if (data.isEmpty()) {
					JOptionPane.showMessageDialog(null, "无此学生，请检查学号是否输入正确");
				} else {

					for (int i = 0; i < 11; i++) {
						table.setValueAt(data.get(i), i, 1);
					}

				}

			}
		});

		// 学号输入框键盘事件
		text_seek.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent ke) {
				// 输入框内按下回车键等于点击查找按钮
				if (ke.getKeyCode() == 10) {
					but_seek.doClick();
				}
			}

			public void keyPressed(KeyEvent arg0) {
			}
		});

		// 学号输入框获取焦点事件
		text_seek.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
			}

			public void focusGained(FocusEvent arg0) {
				// 获取焦点时选中全部内容
				text_seek.selectAll();
			}
		});

		// 修改按钮点击事件
		but_change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 判断
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空");
				}

				else {
					// 弹出界面
					new AdminStudentSeekSaveDialog(adminMainFrame, table.getValueAt(0, 1).toString(), table);

				}

			}
		});

		// 学生注销点击事件，删除学生后要删除与他相关的所有信息，包括各种表的信息
		but_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空");
				}

				else {
					int choice = JOptionPane.showConfirmDialog(null, "你确定注销该学生学籍吗", "提示信息", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						stuinfoDao.deleteStu(table.getValueAt(0, 1).toString());
						JOptionPane.showMessageDialog(null, "删除成功");
						refreshStudentSeek();
					}
				}
			}

		});

		// 查看成绩点击事件
		but_grade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空");
				}

				else {
					// 弹出界面
					new AdminScoreSeek(table.getValueAt(0, 1).toString());

				}

			}
		});

		// 修改成绩点击事件
		but_gradechange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空");
				}

				else {
					// 弹出界面
					new AdminScoreChange(table.getValueAt(0, 1).toString());

				}
			}
		});

		// 录入成绩点击事件，已知道学号，课程下拉，自动填充课程姓名，
		but_gradelogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空");
				}

				else {
					new ScoreloginDialog(amf, table.getValueAt(0, 1).toString());
				}
			}
		});

		this.add(but_gradelogin);
		this.add(but_gradechange);
		this.add(but_change);
		this.add(but_cancel);
		this.add(but_grade);
		this.add(jp_info);
		this.add(jp_seek);
		this.setLayout(null);

	}

	// 清空面板上显示的所有信息
	public void refreshStudentSeek() {
		text_seek.setText("输入学号查找");
		for (int i = 0; i < 11; i++) {
			table.setValueAt("", i, 1);
		}
	}

	public DefaultTableModel setTable(String stuid) {
		Vector data = stuinfoDao.seekStu(stuid);
		DefaultTableModel model = new DefaultTableModel();
		model.addRow(data);
		return model;
	}
   
	
	
	
}
