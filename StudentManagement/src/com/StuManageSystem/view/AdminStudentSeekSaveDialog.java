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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.StuManageSystem.bean.Hat_province;
import com.StuManageSystem.bean.Stu_info;
import com.StuManageSystem.dao.AdminStudentDAO;
import com.StuManageSystem.dao.CityDAO;
import com.StuManageSystem.dao.ProvinceDAO;
import com.StuManageSystem.dao.Stu_infoDAO;

//�����ѯѧ�����е��޸�ҳ��
public class AdminStudentSeekSaveDialog extends JDialog {
	private JLabel stunamelab;// ѧ������
	private JLabel stuidlab;// ѧ��ѧ��
	private JLabel stusexlab;// ѧ���Ա�
	private JLabel stubirthlab;// ѧ������
	private JLabel stucollegelab;// ѧ��ѧԺ
	private JLabel stugradelab;// ѧ���꼶
	private JLabel stumajorlab;// ѧ��רҵ
	private JLabel stuclasslab;// ѧ���༶
	private JLabel stuplacelab;// ѧ������
	private JLabel stuaddresslab;// ѧ����ַ

	private JTextField stunametxt;// ���������
	private JTextField stuidtxt;// ѧ�������
	private JTextField stucollegetxt;// ѧԺ�����
	private JTextField stugradetxt;// �꼶�����
	private JTextField stumajortxt;// רҵ�����
	private JTextField stuclasstxt;// �༶�����
	private JTextField stuaddresstxt;// ��ַ�����

	private JRadioButton malebutton;// ��ѡ������ť
	private JRadioButton femalebutton;// ��ѡŮ����ť
	private ButtonGroup sexbg;

	private JComboBox yearbox;// �������б�
	private JComboBox monthbox;// �������б�
	private JComboBox daybox;// �������б�
	private JComboBox provincebox;// ʡ�������б�
	private JComboBox citybox;// ���������б�

	private JButton savebutton;// ���水ť


	
	// ��������ѧ��ѧ��
	private String stuid;

	private JTable table;
	
	private Stu_infoDAO stuinfodao;
    private AdminStudentDAO adminstudao;
	
	
	
	public AdminStudentSeekSaveDialog(AdminMainFrame amf, String stuid, JTable table) {
		super(amf, true);

		this.stuid = stuid;
		this.table = table;
		
	

	
	

		// ѧ������ʵ����
		stuinfodao = new Stu_infoDAO();
		adminstudao = new AdminStudentDAO();

		Font font1 = new Font("΢���ź�", Font.BOLD, 20);

		stunamelab = new JLabel("������");
		stunamelab.setFont(font1);
		stunamelab.setBounds(400, 20, 100, 50);

		stunametxt = new JTextField(16);
		stunametxt.setBounds(500, 25, 200, 40);

		stuidlab = new JLabel("ѧ�ţ�");
		stuidlab.setFont(font1);
		stuidlab.setBounds(400, 80, 100, 50);

		stuidtxt = new JTextField(16);
		stuidtxt.setBounds(500, 85, 200, 40);
		stuidtxt.setEditable(false);

		stusexlab = new JLabel("�Ա�");
		stusexlab.setFont(font1);
		stusexlab.setBounds(400, 140, 100, 50);

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

		stucollegelab = new JLabel("ѧԺ��");
		stucollegelab.setFont(font1);
		stucollegelab.setBounds(400, 200, 100, 50);
		stucollegetxt = new JTextField(16);
		stucollegetxt.setBounds(500, 205, 200, 40);

		stumajorlab = new JLabel("רҵ��");
		stumajorlab.setFont(font1);
		stumajorlab.setBounds(400, 260, 100, 50);
		stumajortxt = new JTextField(16);
		stumajortxt.setBounds(500, 265, 200, 40);

		stugradelab = new JLabel("�꼶��");
		stugradelab.setFont(font1);
		stugradelab.setBounds(400, 320, 100, 50);
		stugradetxt = new JTextField(16);
		stugradetxt.setBounds(460, 325, 100, 40);

		stuclasslab = new JLabel("�༶��");
		stuclasslab.setFont(font1);
		stuclasslab.setBounds(570, 320, 100, 50);
		stuclasstxt = new JTextField(16);
		stuclasstxt.setBounds(630, 325, 100, 40);

		stubirthlab = new JLabel("�������ڣ�");
		stubirthlab.setFont(font1);
		stubirthlab.setBounds(400, 375, 100, 50);

		// ���������
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 380, 60, 40);
		// ���������
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {
			vmonth.add(i);
		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 380, 60, 40);
		// ���������
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {
			vday.add(i);
		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 380, 60, 40);

		// Ϊ�·�����¼���ʹ�����������ı�
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
		stuplacelab = new JLabel("���᣺");
		stuplacelab.setFont(font1);
		stuplacelab.setBounds(400, 435, 100, 50);

		provincebox = new JComboBox();
		provincebox.setBounds(500, 440, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox();
		citybox.setBounds(605, 440, 95, 40);

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

		stuaddresslab = new JLabel("��ַ��");
		stuaddresslab.setFont(font1);
		stuaddresslab.setBounds(400, 495, 100, 50);

		stuaddresstxt = new JTextField(16);
		stuaddresstxt.setBounds(500, 500, 200, 40);

		savebutton = new JButton("����");
		savebutton.setBounds(500, 580, 100, 50);

		// ��ʼѧ��������ʾ

		/*
		 * 12345, ����, ��, 1997, �ӱ�, ʯ��ׯ, �Ҹ���, �ſ�Ժ, ����, 15, 3��
		 */
		Vector data = new Vector();
		data = adminstudao.seekStudent(stuid);

		stuidtxt.setText((String) data.get(0));
		stunametxt.setText((String) data.get(1));
		// �Ա��жϣ�
		String sex = data.get(2).toString();
		if (sex.equals("��")) {
			malebutton.setSelected(true);
		} else {
			femalebutton.setSelected(true);
		}
		// �������ڣ����磺1997-12-20
		String birth = (String) data.get(3);// ȡ����������
		String year = birth.substring(0, 4);// ��ȡ�����
		// ��ȡ���·�
		int str = birth.lastIndexOf("-");
		String month = birth.substring(5, str);

		yearbox.setSelectedItem(Integer.parseInt(year));
		monthbox.setSelectedIndex(Integer.parseInt(month) - 1);

		String day = birth.substring(str + 1);
		daybox.setSelectedItem(Integer.parseInt(day));

		// ��ʾʡ
		provincebox.setSelectedItem(data.get(4));

		// ��ʾ��
		citybox.setSelectedItem(data.get(5));

		// ��ʾ��ַ
		stuaddresstxt.setText(data.get(6).toString());

		// ��ʾѧԺ

		stucollegetxt.setText(data.get(7).toString());

		// ��ʾרҵ

		stumajortxt.setText(data.get(8).toString());

		// ��ʾ�꼶
		stugradetxt.setText(data.get(9).toString());

		// ��ʾ�༶
		stuclasstxt.setText(data.get(10).toString());

		// ���水ť����¼�
		savebutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Stu_info stuinfo = new Stu_info();
				stuinfo.setStu_id(stuidtxt.getText());
				stuinfo.setStu_name(stunametxt.getText());
				if (malebutton.isSelected()) {
					stuinfo.setSex(malebutton.getText());
				} else if (femalebutton.isSelected()) {
					stuinfo.setSex(femalebutton.getText());
				}
				stuinfo.setBirth(yearbox.getSelectedItem().toString() + "-" + monthbox.getSelectedItem().toString()
						+ "-" + daybox.getSelectedItem().toString());
				stuinfo.setProvince(provincebox.getSelectedItem().toString());
				stuinfo.setCity(citybox.getSelectedItem().toString());
				stuinfo.setAddress(stuaddresstxt.getText());
				stuinfo.setCollege(stucollegetxt.getText());
				stuinfo.setMajor(stumajortxt.getText());
				stuinfo.setGrade(stugradetxt.getText());
				stuinfo.setStu_class(stuclasstxt.getText());

				stuinfodao.updateStu(stuinfo);
				
				
				JOptionPane.showMessageDialog(null, "����ɹ�");
				dispose();

				// ���½������
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getStu_id(), 0, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getStu_name(), 1, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getSex(), 2, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getBirth(), 3, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getProvince(), 4, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getCity(), 5, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getAddress(), 6, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getCollege(), 7, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getMajor(), 8, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getGrade(), 9, 1);
				AdminStudentSeekSaveDialog.this.table.setValueAt(stuinfo.getStu_class(), 10, 1);

			}
		});

	
	
		
		this.add(stunamelab);
		this.add(stunametxt);
		this.add(stuidlab);
		this.add(stuidtxt);
		this.add(stusexlab);
		this.add(malebutton);
		this.add(femalebutton);
		this.add(stucollegelab);
		this.add(stucollegetxt);
		this.add(stumajorlab);
		this.add(stumajortxt);
		this.add(stugradelab);
		this.add(stugradetxt);
		this.add(stuclasslab);
		this.add(stuclasstxt);
		this.add(stubirthlab);
		this.add(yearbox);
		this.add(monthbox);
		this.add(daybox);
		this.add(stuplacelab);
		this.add(provincebox);
		this.add(citybox);
		this.add(stuaddresslab);
		this.add(stuaddresstxt);
		this.add(savebutton);

		this.setLayout(null);

		this.setTitle("�޸�ѧ��������Ϣ");
		this.setSize(1100, 700);
		this.setResizable(false);
		this.setVisible(true);

	}

	public ImageIcon setImage(String url) {
		ImageIcon iamge;
		iamge = new ImageIcon(url);
		return iamge;

	}

}
