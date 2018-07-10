package com.StuManageSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.NoticeDAO;

/**
 * 新增公告
 * 
 * @author Joe
 *
 */
public class AddNoticeDialog extends JDialog {
	private JLabel addtitlelab;// 标题
	private JLabel adddatelab;// 日期
	private JLabel addtxtlab;// 内容
	private JLabel nulltxt;// 内容后的空格

	private JTextField addtitletxt;// 输入标题
	private JTextField adddatetxt;// 输入日期

	private JTextArea addtxtarea;// 输入内容
	private JScrollPane txtjsp;

	private AdminNotice adminnotice;

	private JButton savebut;
	private JButton cancelbut;
	private JPanel butjp;// 按钮面板

	private JRadioButton malebutton;// 单选男生按钮
	private JRadioButton femalebutton;// 单选女生按钮
	private ButtonGroup sexbg;

	private JComboBox yearbox;// 年下拉列表
	private JComboBox monthbox;// 月下拉列表
	private JComboBox daybox;// 日下拉列表
	private JComboBox provincebox;// 省份下拉列表
	private JComboBox citybox;// 城市下拉列表

	private JButton savebutton;// 保存按钮

	public AddNoticeDialog(AdminNotice adminnotice) {

		this.adminnotice = adminnotice;

		Font font1 = new Font("微软雅黑", Font.BOLD, 20);
		Font font2 = new Font("微软雅黑", Font.PLAIN, 15);

		addtitlelab = new JLabel("标题：");
		addtitlelab.setFont(font1);
		adddatelab = new JLabel("日期：");
		adddatelab.setFont(font1);
		addtxtlab = new JLabel("内容：");
		addtxtlab.setFont(font1);

		nulltxt = new JLabel("                                         ");
		addtitletxt = new JTextField(18);
		addtitletxt.setText("标题内容必填");

		adddatetxt = new JTextField(18);
		// 提供当前日期及转换
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);
		adddatetxt.setText(time);
		adddatetxt.setEditable(false);// 发布日期不可编辑

		addtxtarea = new JTextArea("请输入内容....", 5, 19);
		addtxtarea.setFont(font2);
		addtxtarea.setLineWrap(true);
		txtjsp = new JScrollPane(addtxtarea);

		butjp = new JPanel();
		savebut = new JButton("保存");
		cancelbut = new JButton("取消");
		butjp.add(savebut);
		butjp.add(cancelbut);

		// 保存
		savebut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				NoticeDAO noticedao = new NoticeDAO();
				Notice notice = new Notice();
				if (addtitletxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "你没有输入标题哦");
				} else {
					notice.setTitle(addtitletxt.getText());
					notice.setNotice_date(adddatetxt.getText());
					notice.setTxt(addtxtarea.getText());
					noticedao.saveNotice(notice);
					// 新增公告完成后，实时刷新公告表数据
					adminnotice.setTable();
					JOptionPane.showMessageDialog(null, "新增公告成功");
					dispose();// 关闭当前窗口
				}

			}
		});
		// 取消
		cancelbut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// 内容输入框获取焦点事件
		addtxtarea.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				// 获取焦点时选中全部内容
				addtxtarea.selectAll();
			}
		});

		// 标题输入框获取焦点事件
		addtitletxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				// 获取焦点时选中全部内容
				addtitletxt.selectAll();
			}
		});

		this.add(addtitlelab);
		this.add(addtitletxt);
		this.add(adddatelab);
		this.add(adddatetxt);
		this.add(addtxtlab);
		this.add(nulltxt);
		this.add(txtjsp);
		this.add(butjp, BorderLayout.SOUTH);

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setTitle("新增公告");
		this.setSize(300, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
