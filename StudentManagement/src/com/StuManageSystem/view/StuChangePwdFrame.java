package com.StuManageSystem.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Log_stu;
import com.StuManageSystem.dao.Log_DAO;

public class StuChangePwdFrame extends Dialog {

	// 标签
	private JLabel jl1;// 学号
	private JLabel jl2;// 原密码
	private JLabel jl3;// 新密码
	private JLabel jl4;// 请再次输入新密码

	// 输入框
	private JTextField id;
	private JPasswordField initPwd;
	private JPasswordField newpwd;
	private JPasswordField newpwd2;

	// 按钮
	private JButton butsure;// 确认修改
	private JButton butcancel;// 取消

	private Stu_initialJFrame Stu_initialJFrame;
	private Log_DAO logStudao;

	public StuChangePwdFrame(Stu_initialJFrame sij, String sid) {

		super(sij, true);// 模态窗口
		this.Stu_initialJFrame = sij;

		// 实例化窗体组件
		Font labFont = new Font("微软雅黑", Font.BOLD, 16);// 标签的字体属性
		jl1 = new JLabel("学号:");
		jl1.setFont(labFont);
		jl2 = new JLabel("原密码:");
		jl2.setFont(labFont);
		jl3 = new JLabel("新密码:");
		jl3.setFont(labFont);
		jl4 = new JLabel("请再次输入新密码:");
		jl4.setFont(labFont);

		id = new JTextField(30);
		id.setText(sid);// 获取学生学号
		id.setEditable(false);// 不可修改,默认当前访问的学生学号

		initPwd = new JPasswordField(30);
		newpwd = new JPasswordField(30);
		newpwd2 = new JPasswordField(30);
		butsure = new JButton("确定");
		butsure.setFont(new Font("微软雅黑", Font.BOLD, 18));
		butcancel = new JButton("取消");
		butcancel.setFont(new Font("微软雅黑", Font.BOLD, 18));

		// 确定修改密码
		butsure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logStudao = new Log_DAO();
				Log_stu logstu = new Log_stu();
				logstu.setUsercode(id.getText());
				logstu.setPwd(initPwd.getText());
				if (logStudao.checkStu(logstu) == false) {
					// 原密码输入错误
					JOptionPane.showMessageDialog(null, "密码错误，请重新输入");
					initPwd.selectAll();
				} else if (newpwd.getText().equals(initPwd.getText())) {
					// 新密码与原密码一样
					JOptionPane.showMessageDialog(null, "原密码与新密码不能一样哦");
					newpwd.selectAll();
				} else if (!(newpwd.getText().equals(newpwd2.getText()))) {
					// 新密码两次输入不一样
					JOptionPane.showMessageDialog(null, "新密码两次输入不一样");
					newpwd.selectAll();
				} else {
					// 修改数据库中该学号对应的密码,提示修改成功
					int choice = JOptionPane.showConfirmDialog(null, "确认修改吗", "提示信息", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						logStudao.updateStuPWD(id.getText(), newpwd.getText());
						JOptionPane.showMessageDialog(null, "密码修改成功");
						dispose();
					}
				}

			}
		});
		
		// 取消修改密码
		butcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		
		/*
		 * 空布局
		 */
		this.add(jl1);
		jl1.setBounds(30, 20, 100, 30);
		this.add(id);
		id.setBounds(30, 50, 240, 30);
		this.add(jl2);
		jl2.setBounds(30, 80, 100, 30);
		this.add(initPwd);
		initPwd.setBounds(30, 110, 240, 30);
		this.add(jl3);
		jl3.setBounds(30, 140, 100, 30);
		this.add(newpwd);
		newpwd.setBounds(30, 170, 240, 30);
		this.add(jl4);
		jl4.setBounds(30, 200, 150, 30);
		this.add(newpwd2);
		newpwd2.setBounds(30, 230, 240, 30);
		this.add(butsure);
		butsure.setBounds(50, 280, 80, 50);
		this.add(butcancel);
		butcancel.setBounds(170, 280, 80, 50);

		// 关闭窗口
		this.addWindowListener(new WindowListener() {
			/* 窗口被激活时调用 */
			public void windowActivated(WindowEvent we) {
			}

			/* 窗口被禁止时调用 */
			public void windowDeactivated(WindowEvent we) {
			}

			/* 窗口被关闭时调用 */
			public void windowClosed(WindowEvent we) {
			}

			/* 窗口正在关闭时调用 */
			public void windowClosing(WindowEvent we) {
				dispose();
			}

			/* 窗口最小化时调用 */
			public void windowIconified(WindowEvent we) {
			}

			/* 窗口恢复时调用 */
			public void windowDeiconified(WindowEvent we) {
			}

			/* 窗口打开时调用 */
			public void windowOpened(WindowEvent we) {
			}
		});

		this.setLayout(null);
		this.setTitle("修改密码");
		this.setSize(300, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
