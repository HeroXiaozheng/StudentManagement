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
import com.StuManageSystem.bean.Stu_info;
import com.StuManageSystem.dao.CityDAO;
import com.StuManageSystem.dao.ProvinceDAO;
import com.StuManageSystem.dao.Stu_infoDAO;

public class AdminStudentAdd extends JPanel {

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

	
	
	private JLabel namewarn;// ����Ϊ��ʱ����ʾ
	private JLabel numwarn;// ����Ϊ��ʱ����ʾ
	private JLabel majorwarn;// רҵΪ��ʱ����ʾ
	private JLabel collegewarn;// ѧԺΪ��ʱ����ʾ
	private JLabel gradewarn;// �꼶Ϊ��ʱ����ʾ
	private JLabel classwarn;// �༶Ϊ��ʱ����ʾ
	private JLabel addresswarn;// ��ַΪ��ʱ����ʾ

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

	private Stu_infoDAO stuinfodao;
	
	public AdminStudentAdd() {

		stuinfodao = new Stu_infoDAO();
		
		
		Font font1 = new Font("΢���ź�", Font.BOLD, 20);
      
		// ����Ϊ��ʱ����ʾ
		namewarn = new JLabel("��������Ϊ��");
		namewarn.setBounds(710, 10, 100, 50);
		namewarn.setVisible(false);
		// ����Ϊ��ʱ����ʾ
		numwarn = new JLabel("ѧ�Ų���Ϊ��");
		numwarn.setBounds(710, 70, 100, 50);
		numwarn.setVisible(false);
		// ѧԺΪ��ʱ����ʾ
		collegewarn = new JLabel("ѧԺ����Ϊ��");
		collegewarn.setBounds(710, 190, 100, 50);
		collegewarn.setVisible(false);
		// רҵΪ��ʱ����ʾ
		majorwarn = new JLabel("רҵ����Ϊ��");
		majorwarn.setBounds(710, 250, 100, 50);
		majorwarn.setVisible(false);
		// �꼶Ϊ��ʱ����ʾ
		gradewarn = new JLabel("�꼶����Ϊ��");
		gradewarn.setBounds(460, 338, 100, 50);
		gradewarn.setVisible(false);
		// �༶Ϊ��ʱ����ʾ
		classwarn = new JLabel("�༶����Ϊ��");
		classwarn.setBounds(730, 310, 100, 50);
		classwarn.setVisible(false);
		// ��ַΪ��ʱ����ʾ
		addresswarn = new JLabel("��ַ����Ϊ��");
		addresswarn.setBounds(710, 485, 100, 50);
		addresswarn.setVisible(false);

		stunamelab = new JLabel("������");
		stunamelab.setFont(font1);
		stunamelab.setBounds(400, 10, 100, 50);

		stunametxt = new JTextField(16);
		stunametxt.setBounds(500, 15, 200, 40);

		// ��������򽹵��¼�
		stunametxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stunametxt.getText().equals("")) {
					namewarn.setVisible(true);
					namewarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				namewarn.setVisible(false);
				stunametxt.selectAll();
			}
		});

		stuidlab = new JLabel("ѧ�ţ�");
		stuidlab.setFont(font1);
		stuidlab.setBounds(400, 70, 100, 50);

		stuidtxt = new JTextField(16);
		stuidtxt.setBounds(500, 75, 200, 40);

		// ѧ������򽹵��¼�
		stuidtxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stuidtxt.getText().equals("")) {
					numwarn.setVisible(true);
					numwarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				numwarn.setVisible(false);
				stuidtxt.selectAll();
			}
		});

		stusexlab = new JLabel("�Ա�");
		stusexlab.setFont(font1);
		stusexlab.setBounds(400, 130, 100, 50);

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

		stucollegelab = new JLabel("ѧԺ��");
		stucollegelab.setFont(font1);
		stucollegelab.setBounds(400, 190, 100, 50);
		stucollegetxt = new JTextField(16);
		stucollegetxt.setBounds(500, 195, 200, 40);

		// ѧԱ����򽹵��¼�
		stucollegetxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stucollegetxt.getText().equals("")) {
					collegewarn.setVisible(true);
					collegewarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				collegewarn.setVisible(false);
				stucollegetxt.selectAll();
			}
		});

		stumajorlab = new JLabel("רҵ��");
		stumajorlab.setFont(font1);
		stumajorlab.setBounds(400, 250, 100, 50);
		stumajortxt = new JTextField(16);
		stumajortxt.setBounds(500, 255, 200, 40);

		// ѧ��רҵ����򽹵��¼�
		stumajortxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stumajortxt.getText().equals("")) {
					majorwarn.setVisible(true);
					majorwarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				majorwarn.setVisible(false);
				stumajortxt.selectAll();
			}
		});

		stugradelab = new JLabel("�꼶��");
		stugradelab.setFont(font1);
		stugradelab.setBounds(400, 310, 100, 50);
		stugradetxt = new JTextField(16);
		stugradetxt.setBounds(460, 315, 100, 40);

		// ѧ���꼶����򽹵��¼�
		stugradetxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stugradetxt.getText().equals("")) {
					gradewarn.setVisible(true);
					gradewarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				gradewarn.setVisible(false);
				stugradetxt.selectAll();
			}
		});

		stuclasslab = new JLabel("�༶��");
		stuclasslab.setFont(font1);
		stuclasslab.setBounds(570, 310, 100, 50);
		stuclasstxt = new JTextField(16);
		stuclasstxt.setBounds(630, 315, 100, 40);

		// ѧ���༶����򽹵��¼�
		stuclasstxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stuclasstxt.getText().equals("")) {
					classwarn.setVisible(true);
					classwarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				classwarn.setVisible(false);
				stuclasstxt.selectAll();
			}
		});

		stubirthlab = new JLabel("�������ڣ�");
		stubirthlab.setFont(font1);
		stubirthlab.setBounds(400, 365, 100, 50);

		// ���������
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 370, 60, 40);
		// ���������
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {

			vmonth.add(i);

		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 370, 60, 40);
		// ���������
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {

			vday.add(i);

		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 370, 60, 40);

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
		stuplacelab = new JLabel("���᣺");
		stuplacelab.setFont(font1);
		stuplacelab.setBounds(400, 425, 100, 50);

		provincebox = new JComboBox(new String[] { "��ѡ��..." });
		provincebox.setBounds(500, 425, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox(new String[] { "��ѡ��..." });
		citybox.setBounds(605, 425, 95, 40);

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
		stuaddresslab.setBounds(400, 485, 100, 50);

		stuaddresstxt = new JTextField(16);
		stuaddresstxt.setBounds(500, 490, 200, 40);

		// ��ַ����򽹵��¼�
		stuaddresstxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if (stuaddresstxt.getText().equals("")) {
					addresswarn.setVisible(true);
					addresswarn.setForeground(Color.RED);
				}
			}

			public void focusGained(FocusEvent e) {
				addresswarn.setVisible(false);
				stuaddresstxt.selectAll();
			}
		});

		savebutton = new JButton("����");
		savebutton.setBounds(500, 540, 100, 50);


		// ����ѧ��
		savebutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
            
				
				
				// �ж�ѧ��ѧ�ţ��õ�vector���ؽ����Ȼ����ݷ��ص��Ƿ�Ϊ�����ж�ѧ���Ƿ��ѱ�����
				String stuid = stuidtxt.getText();
				Vector studata = stuinfodao.seekStu(stuid);
				// �ı�����Ϊ�յ��ж�
				if (provincebox.getSelectedItem().toString().equals("��ѡ��...")) {
					JOptionPane.showMessageDialog(null, "�����ü���");
				} else if ((stuidtxt.getText().equals("")) || (stunametxt.getText().equals(""))
						|| (stuaddresstxt.getText().equals("")) || (stucollegetxt.getText().equals(""))
						|| (stumajortxt.getText().equals("")) || (stugradetxt.getText().equals(""))
						|| (stuclasstxt.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "����ѧ������ʧ�ܣ�������Ϣ�Ƿ�ȫ����д����");
				} else if (!studata.isEmpty()) {
					JOptionPane.showMessageDialog(null, "��ѧ���Ѵ���");
					// �ͷŵ�
					studata.removeAllElements();
				} else {
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
					stuinfodao.saveStu_info(stuinfo);

					JOptionPane.showMessageDialog(null, "����ѧ���ɹ�");
				}

			}
		});
		
		
		
		// �����Ϣ��ť�¼�
		/*
		 * btnClear.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { int choice =
		 * JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ������е��������", "��ʾ��Ϣ",
		 * JOptionPane.YES_NO_OPTION); while (choice == 0) { // �������������
		 * stunametxt.setText(" ");; stuidtxt.setText(""); stucollegetxt.setText("");
		 * stugradetxt.setText(""); stumajortxt.setText(""); stuclasstxt.setText("");
		 * stuaddresstxt.setText(""); stuaddresstxt.setText("");
		 * malebutton.setSelected(true); yearbox.setSelectedIndex(0);
		 * provincebox.setSelectedIndex(0); } } });
		 */
     
	
		this.add(stunamelab);
		this.add(stunametxt);
		this.add(namewarn);
		this.add(stuidlab);
		this.add(stuidtxt);
		this.add(numwarn);
		this.add(stusexlab);
		this.add(malebutton);
		this.add(femalebutton);
		this.add(stucollegelab);
		this.add(stucollegetxt);
		this.add(collegewarn);
		this.add(stumajorlab);
		this.add(stumajortxt);
		this.add(majorwarn);
		this.add(stugradelab);
		this.add(stugradetxt);
		this.add(gradewarn);
		this.add(stuclasslab);
		this.add(stuclasstxt);
		this.add(classwarn);
		this.add(stubirthlab);
		this.add(yearbox);
		this.add(monthbox);
		this.add(daybox);
		this.add(stuplacelab);
		this.add(provincebox);
		this.add(citybox);
		this.add(stuaddresslab);
		this.add(stuaddresstxt);
		this.add(addresswarn);
		this.add(savebutton);

		this.setLayout(null);

		this.setSize(1100, 600);

		this.setVisible(true);

	}

}
