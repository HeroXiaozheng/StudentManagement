package com.StuManageSystem.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Hat_province;
import com.StuManageSystem.bean.Tea_info;
import com.StuManageSystem.dao.CityDAO;
import com.StuManageSystem.dao.ProvinceDAO;
import com.StuManageSystem.dao.Tea_infoDAO;

public class AdminTeacherJdialog extends JDialog {

	// private JLabel backimage;
	
	private JLabel teaname;// ��ʦ����
	private JLabel teanum;// ��ʦ����
	private JLabel teasex;// ��ʦ�Ա�
	private JLabel teadate;// ��ʦ��������
	private JLabel teaplace;// ��ʦ����
	private JLabel teacollege;// ��ʦѧԺ
	private JLabel teamajor;// ��ʦרҵ
	private JLabel teaaddress;// ��ʦ��ַ

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

	// ���ô��ݵĲ���
	private AdminMainFrame amf;
	private String teaid;
	private JTable table;
   
	
	
	// ������ʦ����
	Tea_infoDAO teainfodao;
	
	public AdminTeacherJdialog(AdminMainFrame maf, String teaid, JTable table) {
		super(maf, true);

		this.teaid = teaid;
		this.table = table;

		
		// backimage = new JLabel(new ImageIcon("image/back.jpg"));
		// backimage.setBounds(0, 0, 1100, 600);

		teainfodao = new Tea_infoDAO();

		Font font1 = new Font("΢���ź�", Font.BOLD, 20);

		teaname = new JLabel("������");
		teaname.setFont(font1);
		teaname.setBounds(400, 10, 100, 50);

		teanametxt = new JTextField(16);
		teanametxt.setBounds(500, 15, 200, 40);

		teanum = new JLabel("���ţ�");
		teanum.setFont(font1);
		teanum.setBounds(400, 70, 100, 50);

		teanumtxt = new JTextField(16);
		teanumtxt.setBounds(500, 75, 200, 40);
		teanumtxt.setEnabled(false);
		teasex = new JLabel("�Ա�");
		teasex.setFont(font1);
		teasex.setBounds(400, 130, 100, 50);

		sexbg = new ButtonGroup();
		malebutton = new JRadioButton("��");
		femalebutton = new JRadioButton("Ů");
		malebutton.setSelected(true);
		sexbg.add(malebutton);
		sexbg.add(femalebutton);
		malebutton.setBounds(500, 135, 70, 40);
		malebutton.setFont(font1);
		femalebutton.setBounds(630, 135, 70, 40);
		femalebutton.setFont(font1);

		teacollege = new JLabel("ѧԺ��");
		teacollege.setFont(font1);
		teacollege.setBounds(400, 190, 100, 50);
		teacollegetxt = new JTextField(16);
		teacollegetxt.setBounds(500, 195, 200, 40);

		teamajor = new JLabel("רҵ��");
		teamajor.setFont(font1);
		teamajor.setBounds(400, 250, 100, 50);
		teamajortxt = new JTextField(16);
		teamajortxt.setBounds(500, 255, 200, 40);

		teadate = new JLabel("�������ڣ�");
		teadate.setFont(font1);
		teadate.setBounds(400, 310, 100, 50);
		// ���������
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 315, 60, 40);
		// ���������
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {
			vmonth.add(i);
		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 315, 60, 40);
		// ���������
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {
			vday.add(i);
		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 315, 60, 40);

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
		teaplace.setBounds(400, 365, 100, 50);

		provincebox = new JComboBox(new String[] { "��ѡ��..." });
		provincebox.setBounds(500, 370, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox(new String[] { "��ѡ��..." });
		citybox.setBounds(605, 370, 95, 40);

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
		teaaddress.setBounds(400, 425, 100, 50);

		teaaddresstxt = new JTextField(16);
		teaaddresstxt.setBounds(500, 430, 200, 40);

		saveteainfo = new JButton("����");
		saveteainfo.setBounds(500, 510, 100, 50);

		// ��ʾ����ѧ����ʾ�Ľ���
		Vector data = new Vector();
		data = teainfodao.seekTea(teaid);
		// �������
		teanumtxt.setText((String) data.get(0));
		teanametxt.setText(data.get(1).toString());

		// �Ա��жϣ�
		String sex = data.get(2).toString();
		if (sex.equals("��")) {
			malebutton.isSelected();
		} else {
			femalebutton.isSelected();
		}
		// ��������
		String birth = (String) data.get(3);
		String year = birth.substring(0, 4);
		int str = birth.lastIndexOf("-");

		String month = birth.substring(5, str);

		yearbox.setSelectedItem(Integer.parseInt(year));
		monthbox.setSelectedIndex(Integer.parseInt(month) - 1);

		String day = birth.substring(str + 1);
		System.out.println(day);
		daybox.setSelectedItem(Integer.parseInt(day));

		// ��ʾʡ

		provincebox.setSelectedItem(data.get(4));

		// ��ʾ��ַ
		teaaddresstxt.setText(data.get(6).toString());

		// ��ʾѧԺ

		teacollegetxt.setText(data.get(7).toString());

		// ��ʾרҵ

		teamajortxt.setText(data.get(8).toString());
       
		
		
		
		
		// ���水ť����¼�
		saveteainfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Tea_info teainfo = new Tea_info();

				teainfo.setTeacher_id(teanumtxt.getText());
				teainfo.setTeacher_name(teanametxt.getText());
				if (malebutton.isSelected()) {
					teainfo.setSex(malebutton.getText());
				} else if (femalebutton.isSelected()) {
					teainfo.setSex(femalebutton.getText());
				}
				teainfo.setBirth(yearbox.getSelectedItem().toString() + "/" + monthbox.getSelectedItem().toString()
						+ "/" + daybox.getSelectedItem().toString());
				teainfo.setProvince(provincebox.getSelectedItem().toString());
				teainfo.setCity(citybox.getSelectedItem().toString());
				teainfo.setAddress(teaaddresstxt.getText());
				teainfo.setCollege(teacollegetxt.getText());
				teainfo.setMajor(teamajortxt.getText());

				teainfodao.updateTeacher(teainfo, teanumtxt.getText());
				
				
				JOptionPane.showMessageDialog(null, "����ɹ�");

				// ���½������
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getTeacher_id(), 0, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getTeacher_name(), 1, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getSex(), 2, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getBirth(), 3, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getProvince(), 4, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getCity(), 5, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getAddress(), 6, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getCollege(), 7, 1);
				AdminTeacherJdialog.this.table.setValueAt(teainfo.getMajor(), 8, 1);

			}
		});
     
		this.add(teaname);
		this.add(teanametxt);
		this.add(teanum);
		this.add(teanumtxt);
		this.add(teasex);
		this.add(malebutton);
		this.add(femalebutton);
		this.add(teamajor);
		this.add(teamajortxt);
		this.add(teacollege);
		this.add(teacollegetxt);
		this.add(teadate);
		this.add(yearbox);
		this.add(monthbox);
		this.add(daybox);
		this.add(teaplace);
		this.add(provincebox);
		this.add(citybox);
		this.add(teaaddress);
		this.add(teaaddresstxt);

		this.add(saveteainfo);
		// this.add(backimage);

		this.setLayout(null);

		this.setSize(1100, 600);

		this.setVisible(true);

	}

}
