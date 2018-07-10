package com.StuManageSystem.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Hat_province;
import com.StuManageSystem.bean.Tea_info;
import com.StuManageSystem.dao.CityDAO;
import com.StuManageSystem.dao.ProvinceDAO;
import com.StuManageSystem.dao.Tea_infoDAO;

public class AdminTeacherAdd extends JPanel {

	// private JLabel backimage;

	

	private JLabel teaname;// ��ʦ����
	private JLabel teanum;// ��ʦ����
	private JLabel teasex;// ��ʦ�Ա�
	private JLabel teadate;// ��ʦ��������
	private JLabel teaplace;// ��ʦ����
	private JLabel teacollege;// ��ʦѧԺ
	private JLabel teamajor;// ��ʦרҵ
	private JLabel teaaddress;// ��ʦ��ַ

	private JLabel namewarn;// ����Ϊ��ʱ����ʾ
	private JLabel numwarn;// ����Ϊ��ʱ����ʾ
	private JLabel majorwarn;// רҵΪ��ʱ����ʾ
	private JLabel collegewarn;// ѧԺΪ��ʱ����ʾ
	private JLabel addresswarn;// ��ַΪ��ʱ����ʾ

	private JTextField teanametxt;// ��ʦ���������
	private JTextField teanumtxt;// ��ʦ���������
	private JTextField teamajortxt;// רҵ�����
	private JTextField teacollegetxt;// ѧԺ�����
	private JTextField teaaddresstxt;// ��ַ�����

	private JRadioButton malebutton;// ��ѡ������ť
	private JRadioButton femalebutton;// ��ѡŮ����ť
	private ButtonGroup sexbg;

	private JComboBox yearbox;// ��ʦ��ְ�������ѡ��
	private JComboBox monthbox;// ��ʦ��ְ�·�����ѡ��
	private JComboBox daybox;// ��ʦ��ְ������ѡ��
	private JComboBox provincebox;// ��ʦʡ������ѡ��
	private JComboBox citybox;// ��ʦ�м�����ѡ��

	private JButton saveteainfo;// ���水ť
	private JButton btnClear;// �����ʦ��Ϣ��ť
    
	
	public AdminTeacherAdd() {

		// backimage = new JLabel(new ImageIcon("image/back.jpg"));
		// backimage.setBounds(0, 0, 1100, 600);

		Font font1 = new Font("΢���ź�", Font.BOLD, 20);
    
		
		// ����Ϊ��ʱ����ʾ
		namewarn = new JLabel("��������Ϊ��");
		namewarn.setBounds(710, 20, 100, 50);
		namewarn.setVisible(false);
		// ����Ϊ��ʱ����ʾ
		numwarn = new JLabel("���Ų���Ϊ��");
		numwarn.setBounds(710, 80, 100, 50);
		numwarn.setVisible(false);
		// ѧԺΪ��ʱ����ʾ
		collegewarn = new JLabel("ѧԺ����Ϊ��");
		collegewarn.setBounds(710, 205, 100, 50);
		collegewarn.setVisible(false);
		// רҵΪ��ʱ����ʾ
		majorwarn = new JLabel("רҵ����Ϊ��");
		majorwarn.setBounds(710, 265, 100, 50);
		majorwarn.setVisible(false);
		
		// ��ַΪ��ʱ����ʾ
		addresswarn = new JLabel("��ַ����Ϊ��");
		addresswarn.setBounds(710, 435, 100, 50);
		addresswarn.setVisible(false);

		teaname = new JLabel("������");
		teaname.setFont(font1);
		teaname.setBounds(400, 20, 100, 50);

		teanametxt = new JTextField(16);
		teanametxt.setBounds(500, 25, 200, 40);

		// ��������򽹵��¼�
		teanametxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (teanametxt.getText().equals("")) {
					namewarn.setVisible(true);
					namewarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				namewarn.setVisible(false);
				teanametxt.selectAll();
			}
		});

		teanum = new JLabel("���ţ�");
		teanum.setFont(font1);
		teanum.setBounds(400, 80, 100, 50);

		teanumtxt = new JTextField(16);
		teanumtxt.setBounds(500, 85, 200, 40);

		// ������������¼�
		teanumtxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (teanumtxt.getText().equals("")) {
					numwarn.setVisible(true);
					numwarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				numwarn.setVisible(false);
				teanametxt.selectAll();
			}
		});

		teasex = new JLabel("�Ա�");
		teasex.setFont(font1);
		teasex.setBounds(400, 140, 100, 50);

		sexbg = new ButtonGroup();
		malebutton = new JRadioButton("��");
		femalebutton = new JRadioButton("Ů");
		malebutton.setSelected(true);
		sexbg.add(malebutton);
		sexbg.add(femalebutton);
		malebutton.setBounds(500, 145, 70, 40);
		malebutton.setFont(font1);
		femalebutton.setBounds(630, 145, 70, 40);
		femalebutton.setFont(font1);

		teacollege = new JLabel("ѧԺ��");
		teacollege.setFont(font1);
		teacollege.setBounds(400, 200, 100, 50);
		teacollegetxt = new JTextField(16);
		teacollegetxt.setBounds(500, 205, 200, 40);

		// ѧԺ����򽹵��¼�
		teacollegetxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (teacollegetxt.getText().equals("")) {
					collegewarn.setVisible(true);
					collegewarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				collegewarn.setVisible(false);
				teacollegetxt.selectAll();
			}
		});

		teamajor = new JLabel("רҵ��");
		teamajor.setFont(font1);
		teamajor.setBounds(400, 260, 100, 50);
		teamajortxt = new JTextField(16);
		teamajortxt.setBounds(500, 265, 200, 40);

		// רҵ��������¼�
		teamajortxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (teamajortxt.getText().equals("")) {
					majorwarn.setVisible(true);
					majorwarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				majorwarn.setVisible(false);
				teamajortxt.selectAll();
			}
		});

		teadate = new JLabel("�������ڣ�");
		teadate.setFont(font1);
		teadate.setBounds(400, 320, 100, 50);
		// ���������
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 325, 60, 40);
		// ���������
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {
			vmonth.add(i);
		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 325, 60, 40);
		// ���������
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {
			vday.add(i);
		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 325, 60, 40);

		// Ϊ�·�����¼����������������ı�
		monthbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object o = monthbox.getSelectedItem();
				if (o != null) {
					daybox.removeAllItems();
				}
				int month = Integer.parseInt(o.toString());
				int day = 30;
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					day = 31;
				} else if (month == 2) {
					int year = Integer.parseInt(yearbox.getSelectedItem().toString());
					if (year % 400 == 0) {
						day = 29;
					} else {
						day = 28;
					}
				}
				for (int i = 1; i <= day; i++) {
					daybox.addItem(i);
				}

			}
		});

		teaplace = new JLabel("���᣺");
		teaplace.setFont(font1);
		teaplace.setBounds(400, 375, 100, 50);

		provincebox = new JComboBox(new String[] { "��ѡ��..." });
		provincebox.setBounds(500, 380, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox(new String[] { "��ѡ��..." });
		citybox.setBounds(605, 380, 95, 40);

		provincebox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					CityDAO citydao = new CityDAO();
					citybox.removeAllItems();
					for (Object o : citydao.getCity(provincebox.getSelectedItem().toString())) {

						citybox.addItem((String) o);
					}
				}
			}
		});

		teaaddress = new JLabel("��ַ��");
		teaaddress.setFont(font1);
		teaaddress.setBounds(400, 435, 100, 50);

		teaaddresstxt = new JTextField(16);
		teaaddresstxt.setBounds(500, 440, 200, 40);

		// ��ַ��������¼�
		teaaddresstxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (teaaddresstxt.getText().equals("")) {
					addresswarn.setVisible(true);
					addresswarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				addresswarn.setVisible(false);
				teaaddresstxt.selectAll();
			}
		});

		saveteainfo = new JButton("����");
		saveteainfo.setBounds(500, 530, 100, 50);
		
		// ���水ť����¼�
		saveteainfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 //��Ƭ�ж�
			
				
				
				
				// �õ�����,���ݹ����������ݣ��жϹ����Ƿ��ظ�
				String teaid = teanumtxt.getText();
				Tea_infoDAO teadao = new Tea_infoDAO();
				Vector teadata = teadao.seekTea(teaid);
				// �ж����ݲ�Ϊ��
				if (provincebox.getSelectedItem().toString().equals("��ѡ��...")) {
					JOptionPane.showMessageDialog(null, "�����ü���");
				} else if ((teanumtxt.getText().equals("")) || (teanametxt.getText().equals(""))
						|| (teaaddresstxt.getText().equals("")) || (teacollegetxt.getText().equals(""))
						|| (teamajortxt.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "������ʦ����ʧ�ܣ�������Ϣ�Ƿ�ȫ����д����");
				} else if (!teadata.isEmpty()) {
					JOptionPane.showMessageDialog(null, "�ù����Ѿ�����");
					teadata.removeAllElements();

				} else {
					Tea_infoDAO teainfodao = new Tea_infoDAO();
					Tea_info teainfo = new Tea_info();
					teainfo.setTeacher_id(teanumtxt.getText());
					teainfo.setTeacher_name(teanametxt.getText());
					if (malebutton.isSelected()) {
						teainfo.setSex(malebutton.getText());
					} else if (femalebutton.isSelected()) {
						teainfo.setSex(femalebutton.getText());
					}
					teainfo.setBirth(yearbox.getSelectedItem().toString() + "-" + monthbox.getSelectedItem().toString()
							+ "-" + daybox.getSelectedItem().toString());
					teainfo.setProvince(provincebox.getSelectedItem().toString());
					teainfo.setCity(citybox.getSelectedItem().toString());
					teainfo.setAddress(teaaddresstxt.getText());
					teainfo.setCollege(teacollegetxt.getText());
					teainfo.setMajor(teamajortxt.getText());
					teainfodao.saveTea_info(teainfo);// ִ�в����������ݿ������Ϣ
					 
			      
					JOptionPane.showMessageDialog(null, "����ɹ�");
				}

			}
		});
     
		
		
		
		
		this.add(teaname);
		this.add(teanametxt);
		this.add(namewarn);
		this.add(teanum);
		this.add(teanumtxt);
		this.add(numwarn);
		this.add(teasex);
		this.add(malebutton);
		this.add(femalebutton);
		this.add(teamajor);
		this.add(teamajortxt);
		this.add(majorwarn);
		this.add(teacollege);
		this.add(teacollegetxt);
		this.add(collegewarn);
		this.add(teadate);
		this.add(yearbox);
		this.add(monthbox);
		this.add(daybox);
		this.add(teaplace);
		this.add(provincebox);
		this.add(citybox);
		this.add(teaaddress);
		this.add(teaaddresstxt);
		this.add(addresswarn);

		this.add(saveteainfo);
		// this.add(btnClear);

		this.setLayout(null);
		this.setSize(1100, 600);

		this.setVisible(true);

	}

}
