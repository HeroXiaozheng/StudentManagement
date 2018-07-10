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
 * ��ʦ��¼�����
 * @author Joe
 *
 */

public class Tea_initialJFrame extends JFrame {
	private JLabel date_lab;
	private JButton butInfo;// ������Ϣ
	private JButton butCourse;// �γ���Ϣ
	private JButton butScore;// �ɼ���Ϣ
	private JPanel jp;
	private JLabel announcement1;
	private JLabel name;
	private JLabel welcome;// ��ӭ
	private JButton log_out;// ע����ť
	private JButton butNotice;// �鿴����
	private JButton butChangePWD;// �޸�����

	// -----------------------------------�Ķ�-------------------------------------
	private JLabel infologo;// ������Ϣǰͼ��
	private JLabel courselogo;// �γ���Ϣǰͼ��
	private JLabel scorelogo;// �ɼ���Ϣǰͼ��
	// -----------------------------------�Ķ�-------------------------------------

	/*
	 * ��������
	 */
	private CardLayout card;
	private JPanel cardPanel;// ����װ��Ƭ�����
	private JTextArea notice; // ��������
	private JScrollPane jsp;
	private JTable teaInfoTable;
	private CourseDAO coursedao;
	private NoticeDAO teaNoticedao;
	private Stu_scoreDAO scoredao;
	private String teacherid;

	// ���幫�濨Ƭ�е����
	private JPanel jpnotice;
	private JLabel titlelab;
	private JLabel datelab;
	private JTextArea txtarea;
	private JScrollPane txtjsp;
	private Notice noticebean = new Notice();

	public Tea_initialJFrame(String teacher_id) {

		teacherid = teacher_id;

		// ���ô������Ϸ���ʾ��ǰ����
		date_lab = new JLabel(DateUtil.getDate());
		date_lab.setFont(new Font("Agency FB", Font.BOLD, 20));// ������������

		// ʵ�����������
		infologo = new JLabel(new ImageIcon("image/������Ϣ.png"));
		infologo.setBounds(110, 6, 40, 40);
		butInfo = new JButton("������Ϣ");
		butInfo.setLayout(null);
		butInfo.add(infologo);

		courselogo = new JLabel(new ImageIcon("image/�γ̱�.png"));
		courselogo.setBounds(110, 6, 40, 40);
		butCourse = new JButton("�οΰ���");
		butCourse.setLayout(null);
		butCourse.add(courselogo);

		scorelogo = new JLabel(new ImageIcon("image/�ɼ�����.png"));
		scorelogo.setBounds(110, 6, 40, 40);
		butScore = new JButton("ѧ���ɼ�");
		butScore.setLayout(null);
		butScore.add(scorelogo);

		butInfo.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		butCourse.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		butScore.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		jp = new JPanel();
		jp.setLayout(new GridLayout(1, 3));
		jp.add(butInfo);
		jp.add(butCourse);
		jp.add(butScore);

		notice = new JTextArea(500, 500);
		/*
		 * ��ȡ������ʾ�ڴ������Ϸ�
		 */
		// -----------------------------------�Ķ�-------------------------------------
		Tea_infoDAO teainfodao = new Tea_infoDAO();
		String name1 = teainfodao.getTeaInfoName(teacher_id);
		welcome = new JLabel(name1 + "��ʦ,��ӭ��!");
		// -----------------------------------�Ķ�-------------------------------------
		welcome.setFont(new Font("΢���ź�", Font.PLAIN, 18));

		// -----------------------------------�Ķ�-------------------------------------
		log_out = new JButton("<html><u>ע��</u></html>");// �����»���
		log_out.setContentAreaFilled(false);// ���ð�ť͸��
		log_out.setBorder(null);// ���ð�ťû�б߿�
		log_out.setForeground(new Color(0, 113, 193));
		// -----------------------------------�Ķ�-------------------------------------
		log_out.setFont(new Font("΢���ź�", Font.BOLD, 14));

		butNotice = new JButton("�鿴ȫ������");
		butNotice.setFont(new Font("΢���ź�", Font.BOLD, 18));

		// -----------------------------------�Ķ�-------------------------------------
		butChangePWD = new JButton("<html><u>�޸�����</u></html>");
		butChangePWD.setContentAreaFilled(false);// ���ð�ť͸��
		butChangePWD.setBorder(null);// ���ð�ťû�б߿�
		butChangePWD.setForeground(new Color(0, 113, 193));
		// -----------------------------------�Ķ�-------------------------------------
		butChangePWD.setFont(new Font("΢���ź�", Font.BOLD, 14));

		cardPanel = new JPanel();
		card = new CardLayout();
		cardPanel.setLayout(card);// ��Ƭ����

		/*
		 * ����
		 */
		teaNoticedao = new NoticeDAO();
		JTable teanoticetable = new JTable(this.getNoticeModel());// ��ʦ�������
		teanoticetable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ���������ʽ
		teanoticetable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(teanoticetable);// ���þ���
		teanoticetable.setBackground(new Color(238, 238, 238));// ����������ɫ
		teanoticetable.getColumnModel().getColumn(0).setPreferredWidth(850);
		// --------�Ķ�-------------------------------------------------
		teanoticetable.getColumnModel().getColumn(1).setPreferredWidth(50);
		// teanoticetable.getColumnModel().getColumn(2).setPreferredWidth(50);
		// --------�Ķ�-------------------------------------------------
		cardPanel.add("card1", new JScrollPane(teanoticetable));// ���뿨Ƭ

		/*
		 * ���幫���
		 */
		jpnotice = new JPanel();
		titlelab = new JLabel();
		titlelab.setBounds(50, 0, 600, 100);
		titlelab.setFont(new Font("΢���ź�", Font.BOLD, 30));

		datelab = new JLabel();
		datelab.setBounds(50, 100, 1100, 50);
		datelab.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		datelab.setForeground(Color.RED);

		//------------------------------------
		txtarea =new JTextArea();
		txtjsp=new JScrollPane(txtarea);
		txtjsp.setBounds(50, 150, 1000, 350);
		txtarea.setLineWrap(true);
		//-----------------------------------------
		txtarea.setFont(new Font("΢���ź�", Font.PLAIN, 20));
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
		 * ��ʦ������Ϣ��
		 */
		teaInfoTable = new JTable(9, 2);
		// ���б���������
		teaInfoTable.setValueAt("����:", 0, 0);
		teaInfoTable.setValueAt("����:", 1, 0);
		teaInfoTable.setValueAt("�Ա�:", 2, 0);
		teaInfoTable.setValueAt("��������:", 3, 0);
		teaInfoTable.setValueAt("ʡ:", 4, 0);
		teaInfoTable.setValueAt("��:", 5, 0);
		teaInfoTable.setValueAt("��ַ:", 6, 0);
		teaInfoTable.setValueAt("ѧԺ:", 7, 0);
		teaInfoTable.setValueAt("רҵ:", 8, 0);
		// ����ȡ��Ϣ�������
		Vector v = teainfodao.seekTea(teacher_id);
		for (int i = 0; i < 9; i++) {
			teaInfoTable.setValueAt(v.get(i), i, 1);
		}
		this.setTableColimnCerter(teaInfoTable);// ���þ���
		teaInfoTable.setBackground(new Color(238, 238, 238));// ����������ɫ
		teaInfoTable.setRowHeight(60);// �����и�
		teaInfoTable.setEnabled(false);
		teaInfoTable.getColumnModel().getColumn(0).setPreferredWidth(300);
		teaInfoTable.getColumnModel().getColumn(1).setPreferredWidth(715);

		// ȥ����ͷ
		teaInfoTable.getTableHeader().setVisible(false);// ���ñ�ͷ����ʾ
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0)); // ���ñ�ͷ����ѡ�Ԥѡ�߶�Ϊ0
		teaInfoTable.getTableHeader().setDefaultRenderer(renderer);

		cardPanel.add("card2", new JScrollPane(teaInfoTable));// ���뿨Ƭ

		/*
		 * �οΰ���
		 */
		coursedao = new CourseDAO();
		JTable tea_coursetable = new JTable(this.getTeaCourseModel(teacher_id));// ��ʦ�ο���Ϣ����
		tea_coursetable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ��������
		tea_coursetable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(tea_coursetable);// ���þ���
		tea_coursetable.setBackground(new Color(238, 238, 238));// ������ɫ
		tea_coursetable.getColumnModel().getColumn(0).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(1).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(2).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(3).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(4).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(5).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(6).setPreferredWidth(300);
		cardPanel.add("card3", new JScrollPane(tea_coursetable));// ���뿨Ƭ

		/*
		 * ѧ���ɼ�
		 */
		scoredao = new Stu_scoreDAO();
		JTable stuscoretable = new JTable(this.getTeaScoreModel(teacher_id));// �ɼ��������
		stuscoretable.setFont(new Font("΢���ź�", Font.BOLD, 20));// ��������
		stuscoretable.setRowHeight(50);// �����и�
		this.setTableColimnCerter(stuscoretable);// ���þ���
		stuscoretable.setBackground(new Color(238, 238, 238));// ������ɫ
		tea_coursetable.getColumnModel().getColumn(0).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(1).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(2).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(3).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(4).setPreferredWidth(300);
		tea_coursetable.getColumnModel().getColumn(5).setPreferredWidth(300);
		cardPanel.add("card4", new JScrollPane(stuscoretable));// ���뿨Ƭ

		/*
		 * �ղ���
		 */
		this.add(date_lab);
		// -----------------------------------�Ķ�-------------------------------------
		date_lab.setBounds(20, 2, 200, 30);
		// -----------------------------------�Ķ�-------------------------------------
		this.add(jp);
		jp.setBounds(0, 35, 1300, 50);
		this.add(welcome);
		// -----------------------------------�Ķ�-------------------------------------
		welcome.setBounds(900, 2, 200, 30);
		// -----------------------------------�Ķ�-------------------------------------
		this.add(log_out);
		log_out.setBounds(1200, 2, 80, 30);
		// -----------------------------------�Ķ�-------------------------------------
		this.add(cardPanel);
		cardPanel.setBounds(50, 120, 1200, 500);
		// -----------------------------------�Ķ�-------------------------------------
		this.add(butNotice);
		butNotice.setBounds(50, 625, 155, 30);
		this.add(butChangePWD);
		butChangePWD.setBounds(1090, 2, 90, 30);

		// ��ť����
		// ע��,���ص�¼����
		log_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫע����?", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					dispose();
					new LoginFrame();
				}
			}
		});

		// ��ʾ������Ϣ
		butNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card1");// ��ʾ�����1��,������Ϣ
				butInfo.setEnabled(true);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(false);
			}
		});

		// ������ʦ�޸����봰��
		butChangePWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TeaChangePwdFrame(Tea_initialJFrame.this, teacherid);// ��ʾ�޸��������.
			}
		});

		// ��ʾ��ʦ������Ϣ
		butInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card2");// ��ʾ�����2��,������Ϣ
				butInfo.setEnabled(false);
				butCourse.setEnabled(true);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// ��ʾ�οΰ���
		butCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(cardPanel, "card3");// ��ʾ�����3��,�γ���Ϣ
				butInfo.setEnabled(true);
				butCourse.setEnabled(false);
				butScore.setEnabled(true);
				butNotice.setEnabled(true);
			}
		});

		// ��ʾѧ���ɼ�
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

		// -----------------------------------�Ķ�-------------------------------------
		this.setIconImage(new ImageIcon("image/��ʦ.png").getImage());
		// -----------------------------------�Ķ�-------------------------------------

		// �����������
		this.setLayout(null);
		this.setTitle("��ʦ��");
		this.setSize(1300, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/*
	 * ������ݾ���
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
	public DefaultTableModel getTeaCourseModel(String tea_id) {

		// ���ر������
		Vector rowData = coursedao.getTeaCourseData(tea_id);
		// ���ر�����
		Vector columnNames = coursedao.getTeaColumnNames();
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
		Vector rowData = teaNoticedao.getNoticeRowData();
		// ���ر�����
		Vector columnNames = teaNoticedao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// ���������ر��ģ��(���̿γ̵�ѧ���ɼ�)
	public DefaultTableModel getTeaScoreModel(String tea_id) {

		// ���ر������
		Vector rowData = scoredao.getTeaScoreData(tea_id);
		// ���ر�����
		Vector columnNames = scoredao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

}
