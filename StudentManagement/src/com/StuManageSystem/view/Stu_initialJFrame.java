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
	
	private JLabel date_lab;// ʱ����Ϣ
	private JButton butInfo;// ������Ϣ
	private JButton butCourse;// �γ���Ϣ
	private JButton butScore;// �ɼ���Ϣ
	private JPanel jp;

	private JLabel name;
	private JLabel welcome;// ��ӭ���
	private JButton log_out;// ע����ť
	private JButton butNotice;// �鿴����
	private JButton butchangePWD;// �޸�����

	private JLabel infologo;// ������Ϣǰͼ��
	private JLabel courselogo;// �γ���Ϣǰͼ��
	private JLabel scorelogo;// �ɼ���Ϣǰͼ��
	

	/*
	 * ��������
	 */
	private CardLayout card;
	private JPanel cardPanel;// ����װ��Ƭ�����
	private JTextArea notice; // ��������
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

		// �������Ϸ���ʾ��ǰ����
		date_lab = new JLabel(DateUtil.getDate());
		date_lab.setFont(new Font("Agency FB", Font.BOLD, 20));// ������������

		// ������Ϣ��ť
		infologo = new JLabel(new ImageIcon("image/������Ϣ.png"));
		infologo.setBounds(110, 6, 40, 40);
		butInfo = new JButton("������Ϣ");
		butInfo.setLayout(null);// ��ť�ڲ�Ϊ�ղ���
		butInfo.add(infologo);

		// ѧ���γ̰�ť
		courselogo = new JLabel(new ImageIcon("image/�γ̱�.png"));
		courselogo.setBounds(110, 6, 40, 40);
		butCourse = new JButton("ѧ���γ�");
		butCourse.setLayout(null);// ��ť�ڲ�Ϊ�ղ���
		butCourse.add(courselogo);

		// ѧ���ɼ���ť
		scorelogo = new JLabel(new ImageIcon("image/�ɼ�����.png"));
		scorelogo.setBounds(110, 6, 40, 40);
		butScore = new JButton("ѧ���ɼ�");
		butScore.setLayout(null);// ��ť�ڲ�Ϊ�ղ���
		butScore.add(scorelogo);

		// ����������ť����������
		Font btnFont = new Font("΢���ź�", Font.PLAIN, 24);
		butInfo.setFont(btnFont);
		butCourse.setFont(btnFont);
		butScore.setFont(btnFont);

		jp = new JPanel();// װ������ť��JPanel
		jp.setLayout(new GridLayout(1, 3));
		jp.add(butInfo);
		jp.add(butCourse);
		jp.add(butScore);

		
		notice = new JTextArea(500, 500);

		// ��ȡ���û�������ʾ�ڴ������Ϸ�
		Stu_infoDAO stuinfodao = new Stu_infoDAO();
		String userName = stuinfodao.getstuInfoName(usercode);
		welcome = new JLabel(userName + "ͬѧ,��ӭ��!");
		welcome.setFont(new Font("΢���ź�", Font.PLAIN, 16));

		// ע����ǰ�˻���ť
		log_out = new JButton("<html><u>ע��</u></html>");// �����»���
		log_out.setBorder(null);// ���ð�ťû�б߿�
		log_out.setContentAreaFilled(false);// ���ð�ť͸��
		log_out.setForeground(new Color(0, 113, 193));
		log_out.setFont(new Font("΢���ź�", Font.BOLD, 14));

		// �޸����밴ť
		butchangePWD = new JButton("<html><u>�޸�����</u></html>");
		butchangePWD.setBorder(null);// ���ð�ťû�б߿�
		butchangePWD.setContentAreaFilled(false);// ���ð�ť͸��
		butchangePWD.setForeground(new Color(0, 113, 193));
		butchangePWD.setFont(new Font("΢���ź�", Font.BOLD, 14));

		// �鿴ȫ�����水ť
		butNotice = new JButton("�鿴ȫ������");
		butNotice.setEnabled(false);// ��ʼΪ���ɵ��
		butNotice.setFont(new Font("΢���ź�", Font.BOLD, 18));
		cardPanel = new JPanel();
		card = new CardLayout();
		cardPanel.setLayout(card);

		/*
		 * �������
		 */
		stunoticedao = new NoticeDAO();
		JTable stunoticetable = new JTable(this.getNoticeModel());// ������Ϣ������
		stunoticetable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ���������ʽ
		stunoticetable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(stunoticetable);// ���ñ�����ݾ���
		stunoticetable.setBackground(new Color(238, 238, 238));// ����������ɫ
		// ���ù�����п�
		stunoticetable.getColumnModel().getColumn(0).setPreferredWidth(850);
		stunoticetable.getColumnModel().getColumn(1).setPreferredWidth(50);
		cardPanel.add("card1", new JScrollPane(stunoticetable));// ���뿨Ƭ��ȫ�����棩

		/*
		 * ������������
		 */
		jpnotice = new JPanel();
		titlelab = new JLabel();// �������
		titlelab.setBounds(50, 20, 600, 100);
		titlelab.setFont(new Font("΢���ź�", Font.BOLD, 30));

		datelab = new JLabel();// ����ʱ��
		datelab.setBounds(50, 120, 1100, 50);
		datelab.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		datelab.setForeground(Color.RED);// ����Ϊ��ɫ

		txtlab = new JLabel();// ��������
		txtlab.setBounds(50, 170, 1000, 200);
		txtlab.setFont(new Font("΢���ź�", Font.PLAIN, 20));

		jpnotice.add(titlelab);
		jpnotice.add(datelab);
		jpnotice.add(txtlab);
		jpnotice.setLayout(null);// �ղ���
		cardPanel.add("noticecard", jpnotice);// ���뿨Ƭ��ĳ������������ݣ�
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
				// ˫�����������ʾ��������
				if (e.getClickCount() == 2) {
					card.show(cardPanel, "noticecard");
					titlelab.setText("<html>" + stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 0).toString()
							+ "</html>");
					datelab.setText(stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 1).toString());
					txtlab.setText("<html>"
							+ stunoticedao.getDetailNotice(
									stunoticetable.getValueAt(stunoticetable.getSelectedRow(), 0).toString())
							+ "</html>");
					butNotice.setEnabled(true);// �鿴ȫ�����水ť����Ϊ����
				}

			}
		});

		/*
		 * ѧ��������Ϣ��
		 */
		stuInfoTable = new JTable(11, 2);
		// �����б���
		stuInfoTable.setValueAt("ѧ��:", 0, 0);
		stuInfoTable.setValueAt("����:", 1, 0);
		stuInfoTable.setValueAt("�Ա�:", 2, 0);
		stuInfoTable.setValueAt("��������:", 3, 0);
		stuInfoTable.setValueAt("ʡ:", 4, 0);
		stuInfoTable.setValueAt("��:", 5, 0);
		stuInfoTable.setValueAt("��ϸ��ַ:", 6, 0);
		stuInfoTable.setValueAt("ѧԺ:", 7, 0);
		stuInfoTable.setValueAt("רҵ:", 8, 0);
		stuInfoTable.setValueAt("�꼶:", 9, 0);
		stuInfoTable.setValueAt("�༶:", 10, 0);
		// �������ݿ��л�ȡ����Ϣ�������
		String[] s = stuinfodao.getStuInfoData(usercode);
		for (int i = 0; i < 11; i++) {
			stuInfoTable.setValueAt(s[i], i, 1);
		}
		this.setTableColimnCerter(stuInfoTable);// ���þ���
		stuInfoTable.setFont(new Font("΢���ź�", Font.BOLD, 50));
		stuInfoTable.setBackground(new Color(238, 238, 238));// ����������ɫ
		stuInfoTable.setRowHeight(60);// �����и�
		stuInfoTable.setEnabled(false);
		// �����п�
		stuInfoTable.getColumnModel().getColumn(0).setPreferredWidth(315);
		stuInfoTable.getColumnModel().getColumn(1).setPreferredWidth(815);
		// ȥ����ͷ
		stuInfoTable.getTableHeader().setVisible(false);// ���ñ�ͷ����ʾ
		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setPreferredSize(new Dimension(0, 0)); // ���ñ�ͷ����ѡ�Ԥѡ�߶�Ϊ0
		stuInfoTable.getTableHeader().setDefaultRenderer(renderer1);
		cardPanel.add("card2", new JScrollPane(stuInfoTable));// ���뿨Ƭ��ѧ��������Ϣ��

		
		/*
		 * �γ���Ϣ
		 */
		coursedao = new CourseDAO();
		JTable stucoursetable = new JTable(this.getCourseModel(usercode));// �γ���Ϣ������
		stucoursetable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ��������
		stucoursetable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(stucoursetable);// ���þ���
		stucoursetable.setBackground(new Color(238, 238, 238));// ������ɫ
		cardPanel.add("card3", new JScrollPane(stucoursetable));// ���뿨Ƭ

		
		/*
		 * �ɼ���ѯ
		 */
		stuScoredao = new Stu_scoreDAO();
		JTable stuscoretable = new JTable(this.getScoreModel(usercode));// �ɼ���Ϣ������
		stuscoretable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ��������
		stuscoretable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(stuscoretable);// ���þ���
		stuscoretable.setBackground(new Color(238, 238, 238));// ������ɫ
		cardPanel.add("card4", new JScrollPane(stuscoretable));// ���뿨Ƭ

		
		/*
		 * �ղ���
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
		 * ���ְ�ť�����¼�
		 */
		// ע��,���ص�¼����
		log_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫע����ǰ�˻������ص�¼������?", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					//�رյ�ǰ���ڣ����ص�¼����
					dispose();
					new LoginFrame();
				}
			}
		});

		// ��ʾ������Ϣ
		butNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card1");// ��ʾ�����1��,��ȫ��������Ϣ
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(false);
			}
		});

		// ����ѧ���޸����봰��
		butchangePWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StuChangePwdFrame(Stu_initialJFrame.this, usercode);// �����޸��������
			}
		});

		// ��ʾѧ��������Ϣ
		butInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card2");// ��ʾ�����2��,������Ϣ
				butInfo.setEnabled(false);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// ��ʾ�γ���Ϣ
		butCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card3");// ��ʾ�����3��,�γ���Ϣ
				butInfo.setEnabled(true);
				butCourse.setEnabled(false);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// ��ʾ�ɼ���Ϣ
		butScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card4");// ��ʾ�����4��,�ɼ���Ϣ
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(false);
				butNotice.setEnabled(true);
			}
		});

		// �ر�ʱѯ���Ƿ��˳�ϵͳ
		this.addWindowListener(new WindowListener() {
			/* ���ڱ�����ʱ���� */
			public void windowActivated(WindowEvent we) {
			}

			/* ���ڱ���ֹʱ���� */
			public void windowDeactivated(WindowEvent we) {
			}

			/* ���ڱ��ر�ʱ���� */
			public void windowClosed(WindowEvent we) {
			}

			/* �������ڹر�ʱ���� */
			public void windowClosing(WindowEvent we) {
				int n = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳�ϵͳ��?", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					dispose();
				}
			}

			/* ������С��ʱ���� */
			public void windowIconified(WindowEvent we) {
			}

			/* ���ڻָ�ʱ���� */
			public void windowDeiconified(WindowEvent we) {
			}

			/* ���ڴ�ʱ���� */
			public void windowOpened(WindowEvent we) {
			}

		});

		// ���ô����������
		this.setIconImage(new ImageIcon("image/ѧ��.png").getImage());// ���ô���logo
		this.setLayout(null);
		this.setTitle("ѧ����");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	/*
	 * ���ñ�����ݾ��еķ���
	 */
	public void setTableColimnCerter(JTable table) {
		DefaultTableCellHeaderRenderer r = new DefaultTableCellHeaderRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
	}

	
	/**
	 * ���ز�ѯ��������ģ��
	 *
	 */
	// ���������ر��ģ��(�γ���Ϣ)
	public DefaultTableModel getCourseModel(String stu_id) {

		// ���ر������
		Vector rowData = coursedao.getStuCourseData(stu_id);
		// ���ر�����
		Vector columnNames = coursedao.getStuColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// ���������ر��ģ��(����)
	public DefaultTableModel getNoticeModel() {

		// ���ر������
		Vector rowData = stunoticedao.getNoticeRowData();
		// ���ر�����
		Vector columnNames = stunoticedao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// ���������ر��ģ��(�ɼ���Ϣ)
	public DefaultTableModel getScoreModel(String stu_id) {

		// ���ر������
		Vector rowData = stuScoredao.getStuScoreData(stu_id);
		// ���ر�����
		Vector columnNames = stuScoredao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

}
