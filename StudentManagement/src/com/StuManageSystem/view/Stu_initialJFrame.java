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

import com.StuManageSystem.bean.Notice;
import com.StuManageSystem.dao.CourseDAO;
import com.StuManageSystem.dao.NoticeDAO;
import com.StuManageSystem.dao.Stu_infoDAO;
import com.StuManageSystem.dao.Stu_scoreDAO;
import com.StuManageSystem.util.DateUtil;

import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Stu_initialJFrame extends JFrame {
	
	private JLabel date_lab;// 时间信息
	private JButton butInfo;// 基本信息
	private JButton butCourse;// 课程信息
	private JButton butScore;// 成绩信息
	private JPanel jp;

	private JLabel name;
	private JLabel welcome;// 欢迎语句
	private JButton log_out;// 注销按钮
	private JButton butNotice;// 查看公告
	private JButton butchangePWD;// 修改密码

	private JLabel infologo;// 基本信息前图标
	private JLabel courselogo;// 课程信息前图标
	private JLabel scorelogo;// 成绩信息前图标
	

	/*
	 * 主体内容
	 */
	private CardLayout card;
	private JPanel cardPanel;// 用来装卡片的面板
	private JTextArea notice; // 公告内容
	// private JScrollPane jsp;
	private JScrollPane noticejsp;
	private JTable stuInfoTable;
	private Stu_infoDAO dao;
	private CourseDAO coursedao;
	private NoticeDAO stunoticedao;
	private Stu_scoreDAO stuScoredao;
	private String stu_id;

	private JPanel jpnotice;
	private JLabel titlelab;
	private JLabel datelab;
	private JLabel txtlab;
	private Notice noticebean = new Notice();

	public Stu_initialJFrame(String usercode) {

		// 窗体左上方显示当前日期
		date_lab = new JLabel(DateUtil.getDate());
		date_lab.setFont(new Font("Agency FB", Font.BOLD, 20));// 设置字体属性

		// 基本信息按钮
		infologo = new JLabel(new ImageIcon("image/个人信息.png"));
		infologo.setBounds(110, 6, 40, 40);
		butInfo = new JButton("基本信息");
		butInfo.setLayout(null);// 按钮内部为空布局
		butInfo.add(infologo);

		// 学生课程按钮
		courselogo = new JLabel(new ImageIcon("image/课程表.png"));
		courselogo.setBounds(110, 6, 40, 40);
		butCourse = new JButton("学生课程");
		butCourse.setLayout(null);// 按钮内部为空布局
		butCourse.add(courselogo);

		// 学生成绩按钮
		scorelogo = new JLabel(new ImageIcon("image/成绩中心.png"));
		scorelogo.setBounds(110, 6, 40, 40);
		butScore = new JButton("学生成绩");
		butScore.setLayout(null);// 按钮内部为空布局
		butScore.add(scorelogo);

		// 设置三个按钮的字体属性
		Font btnFont = new Font("微软雅黑", Font.PLAIN, 24);
		butInfo.setFont(btnFont);
		butCourse.setFont(btnFont);
		butScore.setFont(btnFont);

		jp = new JPanel();// 装三个按钮的JPanel
		jp.setLayout(new GridLayout(1, 3));
		jp.add(butInfo);
		jp.add(butCourse);
		jp.add(butScore);

		
		notice = new JTextArea(500, 500);

		// 获取该用户名字显示在窗体右上方
		Stu_infoDAO stuinfodao = new Stu_infoDAO();
		String userName = stuinfodao.getstuInfoName(usercode);
		welcome = new JLabel(userName + "同学,欢迎你!");
		welcome.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		// 注销当前账户按钮
		log_out = new JButton("<html><u>注销</u></html>");// 设置下划线
		log_out.setBorder(null);// 设置按钮没有边框
		log_out.setContentAreaFilled(false);// 设置按钮透明
		log_out.setForeground(new Color(0, 113, 193));
		log_out.setFont(new Font("微软雅黑", Font.BOLD, 14));

		// 修改密码按钮
		butchangePWD = new JButton("<html><u>修改密码</u></html>");
		butchangePWD.setBorder(null);// 设置按钮没有边框
		butchangePWD.setContentAreaFilled(false);// 设置按钮透明
		butchangePWD.setForeground(new Color(0, 113, 193));
		butchangePWD.setFont(new Font("微软雅黑", Font.BOLD, 14));

		// 查看全部公告按钮
		butNotice = new JButton("查看全部公告");
		butNotice.setEnabled(false);// 初始为不可点击
		butNotice.setFont(new Font("微软雅黑", Font.BOLD, 18));
		cardPanel = new JPanel();
		card = new CardLayout();
		cardPanel.setLayout(card);

		/*
		 * 公告界面
		 */
		stunoticedao = new NoticeDAO();
		JTable stunoticetable = new JTable(this.getNoticeModel());// 公告信息界面表格
		stunoticetable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体格式
		stunoticetable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(stunoticetable);// 设置表格内容居中
		stunoticetable.setBackground(new Color(238, 238, 238));// 设置字体颜色
		// 设置公告表列宽
		stunoticetable.getColumnModel().getColumn(0).setPreferredWidth(850);
		stunoticetable.getColumnModel().getColumn(1).setPreferredWidth(50);
		cardPanel.add("card1", new JScrollPane(stunoticetable));// 插入卡片（全部公告）

		/*
		 * 公告表具体内容
		 */
		jpnotice = new JPanel();
		titlelab = new JLabel();// 公告标题
		titlelab.setBounds(50, 20, 600, 100);
		titlelab.setFont(new Font("微软雅黑", Font.BOLD, 30));

		datelab = new JLabel();// 发布时间
		datelab.setBounds(50, 120, 1100, 50);
		datelab.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		datelab.setForeground(Color.RED);// 字体为红色

		txtlab = new JLabel();// 公告内容
		txtlab.setBounds(50, 170, 1000, 200);
		txtlab.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		jpnotice.add(titlelab);
		jpnotice.add(datelab);
		jpnotice.add(txtlab);
		jpnotice.setLayout(null);// 空布局
		cardPanel.add("noticecard", jpnotice);// 插入卡片（某条公告具体内容）
		stunoticetable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// 双击公告标题显示具体内容
				if (e.getClickCount() == 2) {
					card.show(cardPanel, "noticecard");
					titlelab.setText("<html>" + stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 0).toString()
							+ "</html>");
					datelab.setText(stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 1).toString());
					txtlab.setText("<html>"
							+ stunoticedao.getDetailNotice(
									stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 0).toString())
							+ "</html>");
					butNotice.setEnabled(true);// 查看全部公告按钮设置为可用
				}

			}
		});

		/*
		 * 学生个人信息表
		 */
		stuInfoTable = new JTable(11, 2);
		// 设置行标题
		stuInfoTable.setValueAt("学号:", 0, 0);
		stuInfoTable.setValueAt("姓名:", 1, 0);
		stuInfoTable.setValueAt("性别:", 2, 0);
		stuInfoTable.setValueAt("出生日期:", 3, 0);
		stuInfoTable.setValueAt("省:", 4, 0);
		stuInfoTable.setValueAt("市:", 5, 0);
		stuInfoTable.setValueAt("详细地址:", 6, 0);
		stuInfoTable.setValueAt("学院:", 7, 0);
		stuInfoTable.setValueAt("专业:", 8, 0);
		stuInfoTable.setValueAt("年级:", 9, 0);
		stuInfoTable.setValueAt("班级:", 10, 0);
		// 将从数据库中获取的信息插入表中
		String[] s = stuinfodao.getStuInfoData(usercode);
		for (int i = 0; i < 11; i++) {
			stuInfoTable.setValueAt(s[i], i, 1);
		}
		this.setTableColimnCerter(stuInfoTable);// 设置居中
		stuInfoTable.setFont(new Font("微软雅黑", Font.BOLD, 50));
		stuInfoTable.setBackground(new Color(238, 238, 238));// 设置字体颜色
		stuInfoTable.setRowHeight(60);// 设置行高
		stuInfoTable.setEnabled(false);
		// 设置列宽
		stuInfoTable.getColumnModel().getColumn(0).setPreferredWidth(315);
		stuInfoTable.getColumnModel().getColumn(1).setPreferredWidth(815);
		// 去掉表头
		stuInfoTable.getTableHeader().setVisible(false);// 设置表头不显示
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // 设置表头（首选项）预选高度为0
		stuInfoTable.getTableHeader().setDefaultRenderer(renderer1);
		cardPanel.add("card2", new JScrollPane(stuInfoTable));// 插入卡片（学生个人信息）

		
		/*
		 * 课程信息
		 */
		coursedao = new CourseDAO();
		JTable stucoursetable = new JTable(this.getCourseModel(usercode));// 课程信息界面表格
		stucoursetable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体
		stucoursetable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(stucoursetable);// 设置居中
		stucoursetable.setBackground(new Color(238, 238, 238));// 设置颜色
		cardPanel.add("card3", new JScrollPane(stucoursetable));// 插入卡片

		
		/*
		 * 成绩查询
		 */
		stuScoredao = new Stu_scoreDAO();
		JTable stuscoretable = new JTable(this.getScoreModel(usercode));// 成绩信息界面表格
		stuscoretable.setFont(new Font("微软雅黑", Font.BOLD, 20));// 设置字体
		stuscoretable.setRowHeight(50);// 设置行高
		this.setTableColimnCerter(stuscoretable);// 设置居中
		stuscoretable.setBackground(new Color(238, 238, 238));// 设置颜色
		cardPanel.add("card4", new JScrollPane(stuscoretable));// 插入卡片

		
		/*
		 * 空布局
		 */
		this.add(jp);
		jp.setBounds(0, 35, 1300, 50);
		this.add(date_lab);
		date_lab.setBounds(16, 2, 200, 30);
		this.add(welcome);
		welcome.setBounds(950, 2, 200, 30);
		this.add(log_out);
		log_out.setBounds(1200, 2, 80, 30);
		this.add(cardPanel);
		cardPanel.setBounds(50, 120, 1200, 500);
		this.add(butNotice);
		butNotice.setBounds(50, 625, 155, 30);
		this.add(butchangePWD);
		butchangePWD.setBounds(1100, 2, 90, 30);

		
		/*
		 * 各种按钮监听事件
		 */
		// 注销,返回登录界面
		log_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "您确定要注销当前账户并返回登录界面吗?", "提示信息", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					//关闭当前窗口，返回登录界面
					dispose();
					new LoginFrame();
				}
			}
		});

		// 显示公告信息
		butNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card1");// 显示卡面第1个,即全部公告信息
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(false);
			}
		});

		// 弹出学生修改密码窗口
		butchangePWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StuChangePwdFrame(Stu_initialJFrame.this, usercode);// 弹出修改密码界面
			}
		});

		// 显示学生个人信息
		butInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card2");// 显示卡面第2个,个人信息
				butInfo.setEnabled(false);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// 显示课程信息
		butCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card3");// 显示卡面第3个,课程信息
				butInfo.setEnabled(true);
				butCourse.setEnabled(false);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// 显示成绩信息
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

		// 设置窗体基本属性
		this.setIconImage(new ImageIcon("image/学生.png").getImage());// 设置窗体logo
		this.setLayout(null);
		this.setTitle("学生端");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	/*
	 * 设置表格数据居中的方法
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
	public DefaultTableModel getCourseModel(String stu_id) {

		// 返回表格数据
		Vector rowData = coursedao.getStuCourseData(stu_id);
		// 返回表格标题
		Vector columnNames = coursedao.getStuColumnNames();
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
		Vector rowData = stunoticedao.getNoticeRowData();
		// 返回表格标题
		Vector columnNames = stunoticedao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// 构建并返回表格模型(成绩信息)
	public DefaultTableModel getScoreModel(String stu_id) {

		// 返回表格数据
		Vector rowData = stuScoredao.getStuScoreData(stu_id);
		// 返回表格标题
		Vector columnNames = stuScoredao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

}
