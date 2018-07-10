package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import com.StuManageSystem.dao.Tea_infoDAO;

public class AdminTeacherSeek extends JPanel {

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

	private Tea_infoDAO teainfoDao;
	private AdminMainFrame amf;
	private String teaid;

	public AdminTeacherSeek(AdminMainFrame amf) {

		this.amf = amf;

		// 表格设置
		table = new JTable(9, 2);
		table.setValueAt("工号:", 0, 0);
		table.setValueAt("", 0, 1);// 工号设定初始值，防止报空指针错误
		table.setValueAt("姓名:", 1, 0);
		table.setValueAt("性别:", 2, 0);
		table.setValueAt("出生日期:", 3, 0);
		table.setValueAt("省:", 4, 0);
		table.setValueAt("市:", 5, 0);
		table.setValueAt("地址:", 6, 0);
		table.setValueAt("院:", 7, 0);
		table.setValueAt("专业:", 8, 0);
//		table.setRowHeight(50);

		
		table.setFont(new Font("微软雅黑", Font.BOLD, 15));
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getTableHeader().setVisible(false);// 设置表头不显示
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // 设置表头（首选项）预选高度为0
		table.getTableHeader().setDefaultRenderer(renderer1);
		// 加入滚动条
		jp_info = new JPanel(new BorderLayout());
		jp_info.setBounds(100, 0, 800, 350);
		jp_info.add(new JScrollPane(table));
		jp_info.setBounds(150, 100, 800, 300);

		jp_seek = new JPanel(new FlowLayout());
		text_seek = new JTextField(20);
		text_seek.setText("输入工号查找");
		but_seek = new JButton("查找");
		jp_seek.add(text_seek);
		jp_seek.add(but_seek);
		jp_seek.setBounds(350, 50, 400, 100);

		// 按钮
		but_change = new JButton("修改");
		but_change.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_change.setBounds(400, 450, 100, 40);

		but_cancel = new JButton("注销");
		but_cancel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		but_cancel.setBounds(600, 450, 100, 40);
		// 查找工号点击事件
		but_seek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tea_id = text_seek.getText();
				// System.out.println(tea_id);
				teainfoDao = new Tea_infoDAO();

				Vector data = teainfoDao.seekTea(tea_id);

				if (data.isEmpty()) {
					JOptionPane.showMessageDialog(null, "无此教师，请检查工号是否正确");
				} else {

					for (int i = 0; i < data.size(); i++) {
						table.setValueAt(data.get(i), i, 1);
					}

				}
			}
		});

		// 修改教师点击事件
		but_change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "工号不能为空");
				}else {
					new AdminTeacherJdialog(amf, table.getValueAt(0, 1).toString(), table);
				}
				

			}
		});

		// 注销教师
		but_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(0, 1).toString().equals("")) {
					JOptionPane.showMessageDialog(null, "工号不能为空");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "你确定删除该教师吗", "提示信息", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						teainfoDao.deleteTea(text_seek.getText().toString());
						JOptionPane.showMessageDialog(null, "成功注销该教师");
						for (int i = 0; i < 9; i++) {
							table.setValueAt("", i, 1);
						}
						text_seek.setText("输入工号查找");
					}
				}
			}
		});

		// 工号输入框键盘事件
		text_seek.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// 输入框内按下回车键等于点击查找按钮
					but_seek.doClick();
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		this.add(but_change);
		this.add(but_cancel);
		this.add(jp_info);
		this.add(jp_seek);
		this.setLayout(null);
	}

}
