package com.StuManageSystem.view;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.NoticeDAO;
import com.StuManageSystem.dao.CourseDAO;
import com.StuManageSystem.dao.Stu_infoDAO;
import com.StuManageSystem.dao.Stu_scoreDAO;
import com.StuManageSystem.dao.Tea_infoDAO;
import com.StuManageSystem.util.DateUtil;

/**
 * 老师登录后界面
 * @author Joe
 *
 */

public class Tea_initialJFrame extends JFrame {
	private JLabel date_lab;
	private JButton butInfo;// 基本信息
	private JButton butCourse;// 课程信息
	private JButton butScore;// 成绩信息
	private JPanel jp;
	private JLabel announcement1;
	private JLabel name;
	private JLabel welcome;// 欢迎
	private JButton log_out;// 注销按钮
	private JButton butNotice;// 查看公告
	private JButton butChangePWD;// 修改密码

	// -----------------------------------改动-------------------------------------
	private JLabel infologo;// 基本信息前图标
	private JLabel courselogo;// 课程信息前图标
	private JLabel scorelogo;// 成绩信息前图标
	// -----------------------------------改动-------------------------------------

	/*
	 * 主体内容
	 */
	private CardLayout card;
	private JPanel cardPanel;// 用来装卡片的面板
	private JTextArea notice; // 公告内容
	private JScrollPane jsp;
	private JTable teaInfoTable;
	private CourseDAO coursedao;
	private NoticeDAO teaNoticedao;
	private Stu_scoreDAO scoredao;
	private String teacherid;

	// 具体公告卡片中的组件
	private JPanel jpnotice;
	private JLabel titlelab;
	private JLabel datelab;
	private JTextArea txtarea;
	private JScrollPane txtjsp;
	private Notice noticebean = new Notice();

	public Tea_initialJFrame(String teacher_id) {

		teacherid = teacher_id;

		// 设置窗体左上方显示当前日期
		date_lab = new JLabel(DateUtil.getDate());
		date_lab.setFont(new Font("Agency FB", Font.BOLD, 20));// 设置字体属性

		// 实例化窗体组件
		infologo = new JLabel(new ImageIcon("image/个人信息.png"));
		infologo.setBounds(110, 6, 40, 40);
		butInfo = new JButton("基本信息");
		butInfo.setLayout(null);
		butInfo.add(infologo);

		courselogo = new JLabel(new ImageIcon("image/课程表.png"));
		courselogo.setBounds(110, 6, 40, 40);
		butCourse = new JButton("任课安排");
		butCourse.setLayout(null);
		butCourse.add(courselogo);

		scorelogo = new JLabel(new ImageIcon("image/成绩中心.png"));
		scorelogo.setBounds(110, 6, 40, 40);
		butScore = new JButton("学生成绩");
		butScore.setLayout(null);
		butScore.add(scorelogo);

		butInfo.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		butCourse.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		butScore.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 3));
		jp.add(butInfo);
		jp.add(butCourse);
		jp.add(butScore);

		notice = new JTextArea(500, 500);
		/*
		 * 获取名字显示在窗体右上方
		 */
		// -----------------------------------改动-------------------------------------
		Tea_infoDAO teainfodao = new Tea_infoDAO();
		String name1 = teainfodao.getTeaInfoName(teacher_id);
		welcome = new JLabel(name1 + "老师,欢迎你!");
		// -----------------------------------改动-------------------------------------
		welcome.setFont(new Font("微软雅黑", Font.PLAIN, 18));

		// -----------------------------------改动-------------------------------------
		log_out = new JButton("<html><u>注销</u></html>");// 设置下划线
		log_out.setContentAreaFilled(false);// 设置按钮透明
		log_out.setBorder(null);// 设置按钮没有边框
		log_out.setForeground(new Color(0, 113, 193));
		// -----------------------------------改动-------------------------------------
		log_out.setFont(new Font("微软雅黑", Font.BOLD, 14));

		butNotice = new JButton("查看全部公告");
		butNotice.setFont(new Font("微软雅黑", Font.BOLD, 18));

		// -----------------------------------改动-------------------------------------
		butChangePWD = new JButton("<html><u>修改密码</u></html>");
		butChangePWD.setContentAreaFilled(false);// 设置按钮透明
		butChangePWD.setBorder(null);// 设置按钮没有边框
		butChangePWD.setForeground(new Color(0, 113, 193));
		// -----------------------------------改动-------------------------------------
		butChangePWD.setFont(new Font("微软雅黑", Font.BOLD, 14));

		cardPanel = new JPanel();
		card = new CardLayout();
		cardPanel.setLayout(card);// 卡片布局

		/*
		 * 公告
		 */
		teaNoticedao = new NoticeDAO();
		JTable teanoticetable = new JTable(this.getNoticeModel());// 老师公告界面
		teanoticetable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体格式
		teanoticetable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(teanoticetable);// 设置居中
		teanoticetable.setBackground(new Color(238, 238, 238));// 设置字体颜色
		teanoticetable.getColumnModel().getColumn(0).setPreferredWidth(850);
		// --------改动-------------------------------------------------
		teanoticetable.getColumnModel().getColumn(1).setPreferredWidth(50);
		// teanoticetable.getColumnModel().getColumn(2).setPreferredWidth(50);
		// --------改动-------------------------------------------------
		cardPanel.add("card1", new JScrollPane(teanoticetable));// 插入卡片

		/*
		 * 具体公告表
		 */
		jpnotice = new JPanel();
		titlelab = new JLabel();
		titlelab.setBounds(50, 0, 600, 100);
		titlelab.setFont(new Font("微软雅黑", Font.BOLD, 30));

		datelab = new JLabel();
		datelab.setBounds(50, 100, 1100, 50);
		datelab.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		datelab.setForeground(Color.RED);

		//------------------------------------
		txtarea =new JTextArea();
		txtjsp=new JScrollPane(txtarea);
		txtjsp.setBounds(50, 150, 1000, 350);
		txtarea.setLineWrap(true);
		//-----------------------------------------
		txtarea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		jpnotice.add(titlelab);
		jpnotice.add(datelab);
		//------------------------
		jpnotice.add(txtjsp);
		//-----------------------------
		jpnotice.setLayout(null);
		cardPanel.add("noticecard", jpnotice);
		teanoticetable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					card.show(cardPanel, "noticecard");
					titlelab.setText("<html>" + teanoticetable.getValueAt(teanoticetable.getSelectedRow(), 0).toString()
							+ "</html>");
					datelab.setText(teanoticetable.getValueAt(teanoticetable.getSelectedRow(), 1).toString());
					txtarea.setText(teaNoticedao.getDetailNotice(
									teanoticetable.getValueAt(teanoticetable.getSelectedRow(), 0).toString())
							);
					butNotice.setEnabled(true);
				}

			}
		});
		/*
		 * 老师个人信息表
		 */
		teaInfoTable = new JTable(9, 2);
		// 将行标题插入表中
		teaInfoTable.setValueAt("工号:", 0, 0);
		teaInfoTable.setValueAt("姓名:", 1, 0);
		teaInfoTable.setValueAt("性别:", 2, 0);
		teaInfoTable.setValueAt("出生日期:", 3, 0);
		teaInfoTable.setValueAt("省:", 4, 0);
		teaInfoTable.setValueAt("市:", 5, 0);
		teaInfoTable.setValueAt("地址:", 6, 0);
		teaInfoTable.setValueAt("学院:", 7, 0);
		teaInfoTable.setValueAt("专业:", 8, 0);
		// 将获取信息插入表中
		Vector v = teainfodao.seekTea(teacher_id);
		for (int i = 0; i < 9; i++) {
			teaInfoTable.setValueAt(v.get(i), i, 1);
		}
		this.setTableColimnCerter(teaInfoTable);// 设置居中
		teaInfoTable.setBackground(new Color(238, 238, 238));// 设置字体颜色
		teaInfoTable.setRowHeight(60);// 设置行高
		teaInfoTable.setEnabled(false);
		teaInfoTable.getColumnModel().getColumn(0).setPreferredWidth(300);
		teaInfoTable.getColumnModel().getColumn(1).setPreferredWidth(715);

		// 去掉表头
		teaInfoTable.getTableHeader().setVisible(false);// 设置表头不显示
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0)); // 设置表头（首选项）预选高度为0
		teaInfoTable.getTableHeader().setDefaultRenderer(renderer);

		cardPanel.add("card2", new JScrollPane(teaInfoTable));// 插入卡片

		/*
		 * 任课安排
		 */
		coursedao = new CourseDAO();
		JTable tea_coursetable = new JTable(this.getTeaCourseModel(teacher_id));// 老师任课信息界面
		tea_coursetable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体
		tea_coursetable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(tea_coursetable);// 设置居中
		tea_coursetable.setBackground(new Color(238, 238, 238));// 设置颜色
		tea_coursetable.getColumnModel().getColumn(0).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(1).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(2).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(3).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(4).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(5).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(6).setPreferredWidth(300);
		cardPanel.add("card3", new JScrollPane(tea_coursetable));// 插入卡片

		/*
		 * 学生成绩
		 */
		scoredao = new Stu_scoreDAO();
		JTable stuscoretable = new JTable(this.getTeaScoreModel(teacher_id));// 成绩公告界面
		stuscoretable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体
		stuscoretable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(stuscoretable);// 设置居中
		stuscoretable.setBackground(new Color(238, 238, 238));// 设置颜色
		tea_coursetable.getColumnModel().getColumn(0).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(1).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(2).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(3).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(4).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(5).setPreferredWidth(300);
		cardPanel.add("card4", new JScrollPane(stuscoretable));// 插入卡片

		/*
		 * 空布局
		 */
		this.add(date_lab);
		// -----------------------------------改动-------------------------------------
		date_lab.setBounds(20, 2, 200, 30);
		// -----------------------------------改动-------------------------------------
		this.add(jp);
		jp.setBounds(0, 35, 1300, 50);
		this.add(welcome);
		// -----------------------------------改动-------------------------------------
		welcome.setBounds(900, 2, 200, 30);
		// -----------------------------------改动-------------------------------------
		this.add(log_out);
		log_out.setBounds(1200, 2, 80, 30);
		// -----------------------------------改动-------------------------------------
		this.add(cardPanel);
		cardPanel.setBounds(50, 120, 1200, 500);
		// -----------------------------------改动-------------------------------------
		this.add(butNotice);
		butNotice.setBounds(50, 625, 155, 30);
		this.add(butChangePWD);
		butChangePWD.setBounds(1090, 2, 90, 30);

		// 按钮设置
		// 注销,返回登录界面
		log_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "您确定要注销吗?", "提示信息", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					dispose();
					new LoginFrame();
				}
			}
		});

		// 显示公告信息
		butNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card1");// 显示卡面第1个,公告信息
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(false);
			}
		});

		// 弹出教师修改密码窗口
		butChangePWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TeaChangePwdFrame(Tea_initialJFrame.this, teacherid);// 显示修改密码界面.
			}
		});

		// 显示教师个人信息
		butInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card2");// 显示卡面第2个,个人信息
				butInfo.setEnabled(false);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// 显示任课安排
		butCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card3");// 显示卡面第3个,课程信息
				butInfo.setEnabled(true);
				butCourse.setEnabled(false);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// 显示学生成绩
		butScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card4");// 显示卡面第4个,成绩信息
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(false);
				butNotice.setEnabled(true);
			}
		});

		// 关闭时询问是否退出系统
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
				int n = JOptionPane.showConfirmDialog(null, "您确定要退出系统吗?", "提示信息", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					dispose();
				}
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

		// -----------------------------------改动-------------------------------------
		this.setIconImage(new ImageIcon("image/老师.png").getImage());
		// -----------------------------------改动-------------------------------------

		// 窗体基本属性
		this.setLayout(null);
		this.setTitle("教师端");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/*
	 * 表格数据居中
	 */
	public void setTableColimnCerter(JTable table) {
		DefaultTableCellHeaderRenderer r = new DefaultTableCellHeaderRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
	}

	/**
	 * 返回查询返回数据模型
	 *
	 */
	// 构建并返回表格模型(课程信息)
	public DefaultTableModel getTeaCourseModel(String tea_id) {

		// 返回表格数据
		Vector rowData = coursedao.getTeaCourseData(tea_id);
		// 返回表格标题
		Vector columnNames = coursedao.getTeaColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// 构建并返回表格模型(公告)
	public DefaultTableModel getNoticeModel() {

		// 返回表格数据
		Vector rowData = teaNoticedao.getNoticeRowData();
		// 返回表格标题
		Vector columnNames = teaNoticedao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// 构建并返回表格模型(所教课程的学生成绩)
	public DefaultTableModel getTeaScoreModel(String tea_id) {

		// 返回表格数据
		Vector rowData = scoredao.getTeaScoreData(tea_id);
		// 返回表格标题
		Vector columnNames = scoredao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

}
