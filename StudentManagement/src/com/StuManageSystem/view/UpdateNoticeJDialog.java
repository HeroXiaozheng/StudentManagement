package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.NoticeDAO;

public class UpdateNoticeJDialog extends JDialog {

	private JLabel addtitlelab;// 标题
	private JLabel adddatelab;// 日期
	private JLabel addtxtlab;// 内容
	private JLabel nulltxt;// 内容后的空格

	private JTextField addtitletxt;// 输入标题
	private JTextField adddatetxt;// 输入日期

	private JTextArea addtxtarea;// 输入内容
	private JScrollPane txtjsp;

	private JButton savebut;
	private JButton cancelbut;
	private JPanel butjp;// 按钮面板

	private NoticeDAO noticedao = new NoticeDAO();
	private AdminNotice mf;

	// 修改公告事件
	public UpdateNoticeJDialog(AdminNotice mf) {

		this.mf = mf;

		JTable noticetable = mf.getNoticeTable();
		Font font1 = new Font("微软雅黑", Font.BOLD, 20);
		Font font2 = new Font("微软雅黑", Font.PLAIN, 15);

		addtitlelab = new JLabel("标题：");
		addtitlelab.setFont(font1);
		adddatelab = new JLabel("时间：");
		adddatelab.setFont(font1);
		addtxtlab = new JLabel("内容：");
		addtxtlab.setFont(font1);

		nulltxt = new JLabel("                                         ");
		addtitletxt = new JTextField(noticetable.getValueAt(noticetable.getSelectedRow(), 0).toString(), 18);
		addtitletxt.setEditable(false);// 标题不可编辑

		adddatetxt = new JTextField(18);
		// 提供当前日期及转换
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);
		adddatetxt.setText(time);
		adddatetxt.setEditable(false);// 发布时间不可编辑

		addtxtarea = new JTextArea(
				noticedao.getDetailNotice(noticetable.getValueAt(noticetable.getSelectedRow(), 0).toString()), 5, 19);
		String initContent = addtxtarea.getText();
		addtxtarea.setFont(font2);
		addtxtarea.setLineWrap(true);
		txtjsp = new JScrollPane(addtxtarea);

		butjp = new JPanel();
		savebut = new JButton("保存");
		savebut.setEnabled(false);

		savebut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Notice notice = new Notice();
				notice.setTitle(addtitletxt.getText());
				notice.setNotice_date(adddatetxt.getText());
				notice.setTxt(addtxtarea.getText());
				noticedao.updateNotice(notice);
				mf.setTable();
				JOptionPane.showMessageDialog(null, "修改成功");
			}
		});

		cancelbut = new JButton("取消");
		cancelbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addtxtarea.getText().equals(initContent)) {
					dispose();
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "尚未保存修改后的信息，你确定放弃更改吗？", "提示信息",
							JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						dispose();
					}
				}

			}
		});

		// 公告内容输入事件
		addtxtarea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {
				if (addtxtarea.getText().equals(initContent)) {
					savebut.setEnabled(false);
				} else {
					savebut.setEnabled(true);
				}
			}

			public void keyReleased(KeyEvent arg0) {
			}

			public void keyPressed(KeyEvent arg0) {
			}
		});

		butjp.add(savebut);
		butjp.add(cancelbut);

		this.add(addtitlelab);
		this.add(addtitletxt);
		this.add(adddatelab);
		this.add(adddatetxt);
		this.add(addtxtlab);
		this.add(nulltxt);
		this.add(txtjsp);
		this.add(butjp, BorderLayout.SOUTH);

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setTitle("修改公告");
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
