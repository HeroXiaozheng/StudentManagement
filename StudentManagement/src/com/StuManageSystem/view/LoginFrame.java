package com.StuManageSystem.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;

import com.StuManageSystem.bean.Log_root;
import com.StuManageSystem.bean.Log_stu;
import com.StuManageSystem.bean.Log_tea;
import com.StuManageSystem.dao.Log_DAO;

public class LoginFrame extends JFrame {
	private JLabel usercodelab;// 账号
	private JLabel pwdlab;// 密码
	private JLabel usermsg;// 账号不能为空的文字显示
	private JLabel backimage;// 背景图片
	private JLabel title;// 窗口标题
	private JLabel successMsg;// 登录成功时的提示信息

	private JTextField usercodetxt;// 账号输入框
	private JPasswordField pwdtxt;// 密码输入框

	// 单选按钮组
	private JRadioButton stu;// 学生登录
	private JRadioButton tea;// 教师登录
	private JRadioButton root;// 管理员登录
	private ButtonGroup bg;

	private JButton login;// 登录按钮
	private JButton exit;// 退出按钮

	// 右上角按钮图标
	private JButton exitimage;// 退出
	private JButton minimage;// 最小化

	// 坐标数据，用于记录鼠标位置
	private int xOld = 0;
	private int yOld = 0;

	public LoginFrame() {

		// 字体格式
		Font font = new Font("微软雅黑", Font.BOLD, 30);

		// 背景图片
		backimage = new JLabel(new ImageIcon("image/backgroundimage.jpg"));
		backimage.setBounds(0, 0, 500, 400);

		// 窗体标题
		title = new JLabel("学员管理系统登录");
		title.setBounds(10, 0, 300, 50);
		title.setFont(new Font("微软雅黑", Font.BOLD, 20));
		title.setForeground(Color.white);// 字体颜色

		// 右上角关闭图标
		exitimage = new JButton();
		exitimage.setBounds(430, 0, 70, 40);
		exitimage.setIcon(new ImageIcon("image/exit.jpg"));
		exitimage.setBorder(null);// 没有边框

		// 关闭图标鼠标点击事件
		exitimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// 退出
			}
		});
		// 关闭图标鼠标移动显示事件
		exitimage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				exitimage.setIcon(new ImageIcon("image/exit.jpg"));// 鼠标离开
			}

			public void mouseEntered(MouseEvent e) {
				exitimage.setIcon(new ImageIcon("image/exit2.jpg"));// 鼠标进入
			}

		});

		// 最小化图标
		minimage = new JButton();
		minimage.setBounds(360, 0, 70, 40);
		minimage.setIcon(new ImageIcon("image/mini.jpg"));
		minimage.setBorder(null);// 没有边框

		// 最小化图标的鼠标点击事件
		minimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);// 最小化窗体
			}
		});
		// 最小化图标的鼠标移动事件
		minimage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				minimage.setIcon(new ImageIcon("image/mini.jpg"));// 鼠标离开
			}

			public void mouseEntered(MouseEvent e) {
				minimage.setIcon(new ImageIcon("image/mini2.jpg"));// 鼠标进入
			}

		});

		// 代表用户的图标
		usercodelab = new JLabel(new ImageIcon("image/登录页面-用户名.png"));
		usercodelab.setBounds(55, 90, 80, 50);
		usercodelab.setFont(font);
		usercodelab.setForeground(Color.WHITE);

		// 代表密码的图标
		pwdlab = new JLabel(new ImageIcon("image/3 登录密码.png"));
		pwdlab.setBounds(55, 160, 80, 50);
		pwdlab.setFont(font);
		pwdlab.setForeground(Color.WHITE);

		// 账号输入框为空时的警告消息
		usermsg = new JLabel();
		usermsg.setBounds(135, 125, 100, 50);
		usermsg.setFont(new Font("微软雅黑", Font.BOLD, 16));
		usermsg.setForeground(Color.red);

		// 账号输入框
		usercodetxt = new JTextField(20);
		usercodetxt.setFont(new Font("微软雅黑", Font.BOLD, 16));
		usercodetxt.setBounds(135, 95, 300, 40);
		// 账号输入框焦点事件
		usercodetxt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				if (usercodetxt.getText().equals("")) {
					usermsg.setText("账号不能为空");// 输入框没有内容时显示警告信息
				} else {
					usermsg.setText("");// 输入框有内容时关闭警告信息
				}
			}

			public void focusGained(FocusEvent e) {
				usercodetxt.selectAll();// 获取焦点时选中全部内容

			}
		});

		// 密码输入框
		pwdtxt = new JPasswordField(20);
		pwdtxt.setEchoChar('·');// 设置密码框密文符号
		pwdtxt.setFont(new Font("微软雅黑", Font.BOLD, 18));
		pwdtxt.setBounds(135, 165, 300, 40);
		// 密码输入框焦点事件
		pwdtxt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				pwdtxt.selectAll();// 选中框内全部内容

			}
		});

		// 单选按钮组
		stu = new JRadioButton("学生登录");
		tea = new JRadioButton("教师登录");
		root = new JRadioButton("管理员登录");
		bg = new ButtonGroup();
		bg.add(stu);
		bg.add(tea);
		bg.add(root);
		Font btnFont = new Font("微软雅黑", Font.BOLD, 18);// 单选按钮字体属性
		Color btnBackgroundColor = new Color(0, 113, 193);// 单选按钮背景颜色
		stu.setBounds(60, 250, 100, 20);
		stu.setBackground(btnBackgroundColor);
		stu.setFont(btnFont);
		stu.setForeground(Color.WHITE);
		stu.setSelected(true);
		tea.setBounds(190, 250, 100, 20);
		tea.setBackground(btnBackgroundColor);
		tea.setFont(btnFont);
		tea.setForeground(Color.WHITE);
		root.setBounds(320, 250, 120, 20);
		root.setFont(btnFont);
		root.setForeground(Color.WHITE);
		root.setBackground(btnBackgroundColor);

		// 登录成功时显示的提示信息
		successMsg = new JLabel("登录成功，正在加载主页面....");
		successMsg.setForeground(Color.white);
		successMsg.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		successMsg.setBounds(80, 335, 250, 70);
		successMsg.setVisible(false);// 初始设置为不可见

		// 登录按钮
		login = new JButton("登录");
		login.setFont(new Font("微软雅黑", Font.BOLD, 20));
		login.setBounds(80, 310, 120, 40);
		// 登录按钮监听事件
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stu.isSelected()) {
					// 学生登录
					Log_DAO studao = new Log_DAO();
					Log_stu logstu = new Log_stu();
					logstu.setUsercode(usercodetxt.getText());
					logstu.setPwd(pwdtxt.getText());
					if (studao.checkStu(logstu)) {
						successMsg.setVisible(true);// 显示提示信息
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new Stu_initialJFrame(usercodetxt.getText());// 打开学生登录界面
								dispose();// 关闭当前窗口
							}
						});

					} else {
						JOptionPane.showMessageDialog(null, "账号或密码有误！");
					}
				}
				if (tea.isSelected()) {
					// 老师登录
					Log_DAO teadao = new Log_DAO();
					Log_tea logtea = new Log_tea();
					logtea.setUsercode(usercodetxt.getText());
					logtea.setPwd(pwdtxt.getText());
					if (teadao.checkTea(logtea)) {
						successMsg.setVisible(true);// 显示提示信息
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new Tea_initialJFrame(usercodetxt.getText());// 打开老师登录界面
								dispose();// 关闭当前窗口
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "账号或密码有误！");
					}
				}
				if (root.isSelected()) {
					Log_DAO rootdao = new Log_DAO();
					Log_root logroot = new Log_root();
					logroot.setUsercode(usercodetxt.getText());
					logroot.setPwd(pwdtxt.getText());
					if (rootdao.checkRoot(logroot)) {
						successMsg.setVisible(true);// 显示提示信息
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new AdminMainFrame();// 打开管理员界面
								dispose();// 关闭当前窗口
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "账号或密码有误！");
					}
				}

			}

		});

		// 退出按钮
		exit = new JButton("退出");
		exit.setFont(new Font("微软雅黑", Font.BOLD, 20));
		exit.setBounds(300, 310, 120, 40);
		// 退出按钮点击监听事件
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();// 关闭当前窗口

			}
		});

		// 设置窗体去边框之后可以拖动
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xOld = e.getX();// 记录鼠标按下时的坐标
				yOld = e.getY();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				LoginFrame.this.setLocation(xx, yy);// 设置拖拽后，窗口的位置
			}
		});

		// 密码输入框回车事件
		pwdtxt.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				// 在输入框内按下回车键等于点击登录按钮
				if (e.getKeyCode() == 10) {
					login.doClick();
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		/*
		 * 三个单选按钮的键盘响应事件
		 */
		stu.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// 按"回车"键等于按下“登录”按钮
					if (e.getKeyCode() == 10) {
						login.doClick();
					}
				}
			}
		});
		tea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// 按"回车"键等于按下“登录”按钮
					if (e.getKeyCode() == 10) {
						login.doClick();
					}
				}
			}
		});
		root.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// 按"回车"键等于按下“登录”按钮
					if (e.getKeyCode() == 10) {
						login.doClick();
					}
				}
			}
		});

		// 向窗体添加组件
		this.setIconImage(new ImageIcon("image/logo.jpg").getImage());// 设置窗体logo
		this.add(title);
		this.add(exitimage);
		this.add(minimage);
		this.add(usercodelab);
		this.add(pwdlab);
		this.add(usermsg);
		this.add(usercodetxt);
		this.add(pwdtxt);
		this.add(stu);
		this.add(tea);
		this.add(root);
		this.add(login);
		this.add(exit);
		this.add(successMsg);
		this.add(backimage);

		// 设置窗体属性
		this.setLayout(null);
		this.setTitle("用户登录");
		this.setSize(500, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginFrame();

	}

}
