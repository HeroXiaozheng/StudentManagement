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
	private JLabel usercodelab;// �˺�
	private JLabel pwdlab;// ����
	private JLabel usermsg;// �˺Ų���Ϊ�յ�������ʾ
	private JLabel backimage;// ����ͼƬ
	private JLabel title;// ���ڱ���
	private JLabel successMsg;// ��¼�ɹ�ʱ����ʾ��Ϣ

	private JTextField usercodetxt;// �˺������
	private JPasswordField pwdtxt;// ���������

	// ��ѡ��ť��
	private JRadioButton stu;// ѧ����¼
	private JRadioButton tea;// ��ʦ��¼
	private JRadioButton root;// ����Ա��¼
	private ButtonGroup bg;

	private JButton login;// ��¼��ť
	private JButton exit;// �˳���ť

	// ���Ͻǰ�ťͼ��
	private JButton exitimage;// �˳�
	private JButton minimage;// ��С��

	// �������ݣ����ڼ�¼���λ��
	private int xOld = 0;
	private int yOld = 0;

	public LoginFrame() {

		// �����ʽ
		Font font = new Font("΢���ź�", Font.BOLD, 30);

		// ����ͼƬ
		backimage = new JLabel(new ImageIcon("image/backgroundimage.jpg"));
		backimage.setBounds(0, 0, 500, 400);

		// �������
		title = new JLabel("ѧԱ����ϵͳ��¼");
		title.setBounds(10, 0, 300, 50);
		title.setFont(new Font("΢���ź�", Font.BOLD, 20));
		title.setForeground(Color.white);// ������ɫ

		// ���Ͻǹر�ͼ��
		exitimage = new JButton();
		exitimage.setBounds(430, 0, 70, 40);
		exitimage.setIcon(new ImageIcon("image/exit.jpg"));
		exitimage.setBorder(null);// û�б߿�

		// �ر�ͼ��������¼�
		exitimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// �˳�
			}
		});
		// �ر�ͼ������ƶ���ʾ�¼�
		exitimage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				exitimage.setIcon(new ImageIcon("image/exit.jpg"));// ����뿪
			}

			public void mouseEntered(MouseEvent e) {
				exitimage.setIcon(new ImageIcon("image/exit2.jpg"));// ������
			}

		});

		// ��С��ͼ��
		minimage = new JButton();
		minimage.setBounds(360, 0, 70, 40);
		minimage.setIcon(new ImageIcon("image/mini.jpg"));
		minimage.setBorder(null);// û�б߿�

		// ��С��ͼ���������¼�
		minimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);// ��С������
			}
		});
		// ��С��ͼ�������ƶ��¼�
		minimage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				minimage.setIcon(new ImageIcon("image/mini.jpg"));// ����뿪
			}

			public void mouseEntered(MouseEvent e) {
				minimage.setIcon(new ImageIcon("image/mini2.jpg"));// ������
			}

		});

		// �����û���ͼ��
		usercodelab = new JLabel(new ImageIcon("image/��¼ҳ��-�û���.png"));
		usercodelab.setBounds(55, 90, 80, 50);
		usercodelab.setFont(font);
		usercodelab.setForeground(Color.WHITE);

		// ���������ͼ��
		pwdlab = new JLabel(new ImageIcon("image/3 ��¼����.png"));
		pwdlab.setBounds(55, 160, 80, 50);
		pwdlab.setFont(font);
		pwdlab.setForeground(Color.WHITE);

		// �˺������Ϊ��ʱ�ľ�����Ϣ
		usermsg = new JLabel();
		usermsg.setBounds(135, 125, 100, 50);
		usermsg.setFont(new Font("΢���ź�", Font.BOLD, 16));
		usermsg.setForeground(Color.red);

		// �˺������
		usercodetxt = new JTextField(20);
		usercodetxt.setFont(new Font("΢���ź�", Font.BOLD, 16));
		usercodetxt.setBounds(135, 95, 300, 40);
		// �˺�����򽹵��¼�
		usercodetxt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				if (usercodetxt.getText().equals("")) {
					usermsg.setText("�˺Ų���Ϊ��");// �����û������ʱ��ʾ������Ϣ
				} else {
					usermsg.setText("");// �����������ʱ�رվ�����Ϣ
				}
			}

			public void focusGained(FocusEvent e) {
				usercodetxt.selectAll();// ��ȡ����ʱѡ��ȫ������

			}
		});

		// ���������
		pwdtxt = new JPasswordField(20);
		pwdtxt.setEchoChar('��');// ������������ķ���
		pwdtxt.setFont(new Font("΢���ź�", Font.BOLD, 18));
		pwdtxt.setBounds(135, 165, 300, 40);
		// ��������򽹵��¼�
		pwdtxt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				pwdtxt.selectAll();// ѡ�п���ȫ������

			}
		});

		// ��ѡ��ť��
		stu = new JRadioButton("ѧ����¼");
		tea = new JRadioButton("��ʦ��¼");
		root = new JRadioButton("����Ա��¼");
		bg = new ButtonGroup();
		bg.add(stu);
		bg.add(tea);
		bg.add(root);
		Font btnFont = new Font("΢���ź�", Font.BOLD, 18);// ��ѡ��ť��������
		Color btnBackgroundColor = new Color(0, 113, 193);// ��ѡ��ť������ɫ
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

		// ��¼�ɹ�ʱ��ʾ����ʾ��Ϣ
		successMsg = new JLabel("��¼�ɹ������ڼ�����ҳ��....");
		successMsg.setForeground(Color.white);
		successMsg.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		successMsg.setBounds(80, 335, 250, 70);
		successMsg.setVisible(false);// ��ʼ����Ϊ���ɼ�

		// ��¼��ť
		login = new JButton("��¼");
		login.setFont(new Font("΢���ź�", Font.BOLD, 20));
		login.setBounds(80, 310, 120, 40);
		// ��¼��ť�����¼�
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stu.isSelected()) {
					// ѧ����¼
					Log_DAO studao = new Log_DAO();
					Log_stu logstu = new Log_stu();
					logstu.setUsercode(usercodetxt.getText());
					logstu.setPwd(pwdtxt.getText());
					if (studao.checkStu(logstu)) {
						successMsg.setVisible(true);// ��ʾ��ʾ��Ϣ
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new Stu_initialJFrame(usercodetxt.getText());// ��ѧ����¼����
								dispose();// �رյ�ǰ����
							}
						});

					} else {
						JOptionPane.showMessageDialog(null, "�˺Ż���������");
					}
				}
				if (tea.isSelected()) {
					// ��ʦ��¼
					Log_DAO teadao = new Log_DAO();
					Log_tea logtea = new Log_tea();
					logtea.setUsercode(usercodetxt.getText());
					logtea.setPwd(pwdtxt.getText());
					if (teadao.checkTea(logtea)) {
						successMsg.setVisible(true);// ��ʾ��ʾ��Ϣ
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new Tea_initialJFrame(usercodetxt.getText());// ����ʦ��¼����
								dispose();// �رյ�ǰ����
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "�˺Ż���������");
					}
				}
				if (root.isSelected()) {
					Log_DAO rootdao = new Log_DAO();
					Log_root logroot = new Log_root();
					logroot.setUsercode(usercodetxt.getText());
					logroot.setPwd(pwdtxt.getText());
					if (rootdao.checkRoot(logroot)) {
						successMsg.setVisible(true);// ��ʾ��ʾ��Ϣ
						JFrame.setDefaultLookAndFeelDecorated(true);
						JDialog.setDefaultLookAndFeelDecorated(true);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								SubstanceLookAndFeel.setSkin(new BusinessBlueSteelSkin());
								new AdminMainFrame();// �򿪹���Ա����
								dispose();// �رյ�ǰ����
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "�˺Ż���������");
					}
				}

			}

		});

		// �˳���ť
		exit = new JButton("�˳�");
		exit.setFont(new Font("΢���ź�", Font.BOLD, 20));
		exit.setBounds(300, 310, 120, 40);
		// �˳���ť��������¼�
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();// �رյ�ǰ����

			}
		});

		// ���ô���ȥ�߿�֮������϶�
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xOld = e.getX();// ��¼��갴��ʱ������
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
				LoginFrame.this.setLocation(xx, yy);// ������ק�󣬴��ڵ�λ��
			}
		});

		// ���������س��¼�
		pwdtxt.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				// ��������ڰ��»س������ڵ����¼��ť
				if (e.getKeyCode() == 10) {
					login.doClick();
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		/*
		 * ������ѡ��ť�ļ�����Ӧ�¼�
		 */
		stu.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// ��"�س�"�����ڰ��¡���¼����ť
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
					// ��"�س�"�����ڰ��¡���¼����ť
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
					// ��"�س�"�����ڰ��¡���¼����ť
					if (e.getKeyCode() == 10) {
						login.doClick();
					}
				}
			}
		});

		// ����������
		this.setIconImage(new ImageIcon("image/logo.jpg").getImage());// ���ô���logo
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

		// ���ô�������
		this.setLayout(null);
		this.setTitle("�û���¼");
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
