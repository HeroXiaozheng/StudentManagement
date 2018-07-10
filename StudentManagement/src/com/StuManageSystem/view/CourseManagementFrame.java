package com.StuManageSystem.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.StuManageSystem.bean.Stu_course;
import com.StuManageSystem.bean.Tea_course;
import com.StuManageSystem.dao.CourseDAO;
import com.StuManageSystem.dao.Stu_infoDAO;
import com.StuManageSystem.dao.Stu_scoreDAO;
import com.StuManageSystem.dao.Tea_infoDAO;

public class CourseManagementFrame extends JPanel {

	private JLabel couresidlab;// �γ̱��
	private JLabel couresnamelab;// �γ���
	private JLabel courestealab;// �ο���ʦ
	private JLabel couresclasslab;// �༶
	private JLabel couresaddresslab;// ����
	private JLabel couresnumlab;// ����
	private JLabel courestimelab1;// �Ͽ�ʱ��
	private JLabel courestimelab2;// �Ͽ�ʱ��
	private JLabel courestimelab3;// �Ͽ�ʱ��
	private JLabel lab1;// �����������м�ġ�������
	private JLabel lab2;// �����������м�ġ�������
	private JLabel lab3;// �����������м�ġ�������

	private JTextField selectcoursetxt;// ��ѯ��
	private JTextField courseidtxt;// �γ̱�ſ�
	private JTextField coursenametxt;// �γ�����
	private JTextField majortxt;// רҵ���ƿ�

	private JComboBox teaidbox;// �ο���ʦ���������
	private JComboBox addressbox;// ����������
	private JComboBox coursenumbox;// ����������
	private JComboBox courseweekbox1;// ����������
	private JComboBox courseweekbox2;// ����������
	private JComboBox courseweekbox3;// ����������
	private JComboBox courseweekbox4;// ����������
	private JComboBox courseweekbox5;// ����������
	private JComboBox courseweekbox6;// ����������
	private JComboBox daysbox1;// ���ڼ��ڼ���������
	private JComboBox daysbox2;// ���ڼ��ڼ���������
	private JComboBox daysbox3;// ���ڼ��ڼ���������

	private JButton selectbut;// ��ѯ��ť
	private JButton updatebut;// �޸İ�ť
	private JButton deletebut;// ɾ����ť
	private JButton addbut;// ������ť

	private JPanel jp1;// ��������
	private JPanel jp2;// �м������
	private JPanel jp3;// �Ҳఴť

	private JTable coursetable;
	private JScrollPane coursejsp;

	private CourseDAO coursedao = new CourseDAO();

	private Stu_infoDAO stuinfodao = new Stu_infoDAO();

	private Stu_scoreDAO stuscoredao = new Stu_scoreDAO();

	private Tea_course teacourse = new Tea_course();

	private String teacherid;
	private String initMajor;

	public JTable getCoursetable() {
		return coursetable;
	}

	public CourseManagementFrame() {

		Font font1 = new Font("΢���ź�", Font.PLAIN, 15);
		Font font2 = new Font("΢���ź�", Font.PLAIN, 20);

		// ���������
		selectcoursetxt = new JTextField(16);
		selectcoursetxt.setText("����γ����ƻ��߱��");
		selectcoursetxt.setFont(font1);
		selectcoursetxt.setBounds(380, 20, 220, 40);
		selectcoursetxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				selectcoursetxt.selectAll();
			}
		});

		// ��Ӳ�ѯ��ť
		selectbut = new JButton("��ѯ�γ�");
		selectbut.setBounds(610, 20, 120, 40);
		selectbut.setFont(font2);
		// ��Ӳ�ѯ��ť����¼�
		selectbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetable.setModel(getModel());
				// �����Ͽ�ʱ���п�
				TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
				dateColumn.setPreferredWidth(650);
			}
		});

		// ��ӿγ���Ϣ��
		coursetable = new JTable(this.getModel());
		coursetable.setRowHeight(25);
		coursejsp = new JScrollPane(coursetable);
		coursejsp.setBounds(10, 70, 1075, 300);
		// �����Ͽ�ʱ���п�
		TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
		dateColumn.setPreferredWidth(650);

		couresidlab = new JLabel("�γ̱�ţ�");
		couresidlab.setFont(font2);
		couresidlab.setBounds(10, 10, 100, 30);
		// couresnamelab;//�γ���
		couresnamelab = new JLabel("�γ����ƣ�");
		couresnamelab.setFont(font2);
		couresnamelab.setBounds(10, 40, 100, 30);
		// courestealab;//�ο���ʦ
		courestealab = new JLabel("�ο���ʦ��");
		courestealab.setFont(font2);
		courestealab.setBounds(10, 70, 100, 30);
		// couresclasslab;//�༶
		couresclasslab = new JLabel("ר      ҵ��");
		couresclasslab.setFont(font2);
		couresclasslab.setBounds(10, 100, 100, 30);
		// �ص�
		couresaddresslab = new JLabel("��      �ң�");
		couresaddresslab.setFont(font2);
		couresaddresslab.setBounds(10, 130, 100, 30);
		// �γ̱�ſ�
		courseidtxt = new JTextField(16);
		courseidtxt.setBounds(110, 15, 200, 20);
		// �γ�����
		coursenametxt = new JTextField(16);
		coursenametxt.setBounds(110, 45, 200, 20);
		// רҵ���ƿ�
		majortxt = new JTextField(16);
		majortxt.setBounds(110, 105, 200, 20);

		// �ο���ʦ���������
		teaidbox = new JComboBox();
		teaidbox.setBounds(110, 75, 200, 20);

		Tea_infoDAO teainfodao = new Tea_infoDAO();

		for (Object o : teainfodao.getTeaId()) {
			teaidbox.addItem(o);
		}

		// ����������
		String[] classroom = new String[20];
		for (int i = 0; i < 20; i++) {
			if (i < 9) {
				classroom[i] = "����0" + (i + 1);
			} else {
				classroom[i] = "����" + (i + 1);
			}

		}
		addressbox = new JComboBox(classroom);
		addressbox.setBounds(110, 135, 200, 20);

		jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBounds(30, 375, 310, 180);
		jp1.add(couresidlab);
		jp1.add(courseidtxt);
		jp1.add(couresnamelab);
		jp1.add(coursenametxt);
		jp1.add(courestealab);
		jp1.add(teaidbox);
		jp1.add(couresclasslab);
		jp1.add(majortxt);
		jp1.add(couresaddresslab);
		jp1.add(addressbox);
		// Ϊ�ı�����ӻ�ý���ʱѡ����������
		courseidtxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				courseidtxt.selectAll();
			}
		});
		coursenametxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				coursenametxt.selectAll();
			}
		});
		majortxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				majortxt.selectAll();
			}
		});

		// ����
		couresnumlab = new JLabel("һ�ܽ�����");
		couresnumlab.setFont(font2);
		couresnumlab.setBounds(10, 10, 100, 30);
		// �Ͽ�ʱ��
		courestimelab1 = new JLabel("�Ͽ�ʱ�䣺");
		courestimelab1.setFont(font2);
		courestimelab1.setBounds(10, 40, 100, 30);
		// �Ͽ�ʱ��
		courestimelab2 = new JLabel("�Ͽ�ʱ�䣺");
		courestimelab2.setFont(font2);
		courestimelab2.setBounds(10, 70, 100, 30);
		// �Ͽ�ʱ��
		courestimelab3 = new JLabel("�Ͽ�ʱ�䣺");
		courestimelab3.setFont(font2);
		courestimelab3.setBounds(10, 100, 100, 30);

		// ����������
		coursenumbox = new JComboBox(new String[] { "��ѡ��..(һ���������)", "1��", "2��", "3��" });
		coursenumbox.setBounds(110, 15, 360, 20);
		// ���ý���������ļ����¼�
		coursenumbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (coursenumbox.getSelectedItem().toString().equals("��ѡ��..(һ���������)")) {
					courseweekbox1.setEnabled(false);
					courseweekbox4.setEnabled(false);
					daysbox1.setEnabled(false);
					courseweekbox2.setEnabled(false);
					courseweekbox5.setEnabled(false);
					daysbox2.setEnabled(false);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("1��")) {
					courseweekbox1.setEnabled(true);
					courseweekbox4.setEnabled(true);
					daysbox1.setEnabled(true);
					courseweekbox2.setEnabled(false);
					courseweekbox5.setEnabled(false);
					daysbox2.setEnabled(false);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("2��")) {
					courseweekbox1.setEnabled(true);
					courseweekbox4.setEnabled(true);
					daysbox1.setEnabled(true);
					courseweekbox2.setEnabled(true);
					courseweekbox5.setEnabled(true);
					daysbox2.setEnabled(true);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("3��")) {
					courseweekbox1.setEnabled(true);
					courseweekbox4.setEnabled(true);
					daysbox1.setEnabled(true);
					courseweekbox2.setEnabled(true);
					courseweekbox5.setEnabled(true);
					daysbox2.setEnabled(true);
					courseweekbox3.setEnabled(true);
					courseweekbox6.setEnabled(true);
					daysbox3.setEnabled(true);
				}
			}
		});

		// ����������
		String[] week = new String[20];
		for (int i = 0; i < 20; i++) {
			if (i < 9) {
				week[i] = "��0" + (i + 1) + "��";
			} else {
				week[i] = "��" + (i + 1) + "��";
			}

		}
		courseweekbox1 = new JComboBox(week);
		courseweekbox1.setBounds(110, 45, 90, 20);
		lab1 = new JLabel("��");
		lab1.setBounds(200, 45, 20, 20);
		// ����������
		courseweekbox2 = new JComboBox(week);
		courseweekbox2.setBounds(110, 75, 90, 20);
		lab2 = new JLabel("��");
		lab2.setBounds(200, 75, 20, 20);
		// ����������
		courseweekbox3 = new JComboBox(week);
		courseweekbox3.setBounds(110, 105, 90, 20);
		lab3 = new JLabel("��");
		lab3.setBounds(200, 105, 20, 20);
		// ����������
		courseweekbox4 = new JComboBox(week);
		courseweekbox4.setBounds(212, 45, 90, 20);
		// ����������
		courseweekbox5 = new JComboBox(week);
		courseweekbox5.setBounds(212, 75, 90, 20);
		// ����������
		courseweekbox6 = new JComboBox(week);
		courseweekbox6.setBounds(212, 105, 90, 20);

		// ���ڼ��ڼ���������
		String[] days = { "����һ", "���ڶ�", "������", "������", "������", "������", "������" };
		String[] classes = { "��һ���", "�ڶ����", "�������", "���Ĵ��" };
		String s = "";
		Vector vclass = new Vector();
		for (int i = 0; i < days.length; i++) {
			for (int j = 0; j < classes.length; j++) {
				s += days[i] + classes[j];
				vclass.add(s);
				s = "";
			}
		}
		daysbox1 = new JComboBox(vclass);
		daysbox1.setBounds(305, 45, 165, 20);
		// ���ڼ��ڼ���������
		daysbox2 = new JComboBox(vclass);
		daysbox2.setBounds(305, 75, 165, 20);
		// ���ڼ��ڼ���������
		daysbox3 = new JComboBox(vclass);
		daysbox3.setBounds(305, 105, 165, 20);
		// �ж��Ͽ����������ã�ǰһ������������ܴ��ں�һ����
		courseweekbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			    int num1 = Integer.parseInt((courseweekbox1.getSelectedItem().toString().substring(1, 3)));
				System.out.println(num1);
			    int num2 = Integer.parseInt((courseweekbox4.getSelectedItem().toString().substring(1, 3)));
				int num3 = Integer.parseInt((courseweekbox2.getSelectedItem().toString().substring(1, 3)));
				int num4 = Integer.parseInt((courseweekbox5.getSelectedItem().toString().substring(1, 3)));
				int num5 = Integer.parseInt((courseweekbox3.getSelectedItem().toString().substring(1, 3)));

				int num6 = Integer.parseInt((courseweekbox6.getSelectedItem().toString().substring(1, 3)));
				if (coursenumbox.getSelectedItem().toString().equals("1��")) {
					if (num1 > num2) {
						JOptionPane.showMessageDialog(null, "�Ͽ�����������������������");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("2��")) {
					if (num1 > num2 || num3 > num4) {
						JOptionPane.showMessageDialog(null, "�Ͽ�����������������������");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("3��")) {
					if (num1 > num2 || num3 > num4 || num5 > num6) {
						JOptionPane.showMessageDialog(null, "�Ͽ�����������������������");
					}
				}

			}
		});

		daysbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s1 = daysbox1.getSelectedItem().toString();
				String s2 = daysbox2.getSelectedItem().toString();
				String s3 = daysbox3.getSelectedItem().toString();
				if (coursenumbox.getSelectedItem().toString().equals("2��")) {
					if (s2.equals(s1)) {
						JOptionPane.showMessageDialog(null, "�Ͽ�ʱ��������������������");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("3��")) {
					if (s2.equals(s1) || s2.equals(s3) || s3.equals(s1)) {
						JOptionPane.showMessageDialog(null, "�Ͽ�ʱ��������������������");
					}
				}

			}
		});
		daysbox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s1 = daysbox1.getSelectedItem().toString();
				String s2 = daysbox2.getSelectedItem().toString();
				String s3 = daysbox3.getSelectedItem().toString();
				if (coursenumbox.getSelectedItem().toString().equals("3��")) {
					if (s2.equals(s1) || s2.equals(s3) || s3.equals(s1)) {
						JOptionPane.showMessageDialog(null, "�Ͽ�ʱ��������������������");
					}
				}

			}
		});

		// �����Ͽ�ʱ��������������ʼΪ���ɻ�ȡenable
		courseweekbox1.setEnabled(false);
		courseweekbox4.setEnabled(false);
		daysbox1.setEnabled(false);
		courseweekbox2.setEnabled(false);
		courseweekbox5.setEnabled(false);
		daysbox2.setEnabled(false);
		courseweekbox3.setEnabled(false);
		courseweekbox6.setEnabled(false);
		daysbox3.setEnabled(false);

		jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBounds(390, 375, 550, 180);
		jp2.add(couresnumlab);
		jp2.add(courestimelab1);
		jp2.add(courestimelab2);
		jp2.add(courestimelab3);
		jp2.add(coursenumbox);
		jp2.add(courseweekbox1);
		jp2.add(lab1);
		jp2.add(courseweekbox4);
		jp2.add(daysbox1);
		jp2.add(courseweekbox2);
		jp2.add(lab2);
		jp2.add(courseweekbox5);
		jp2.add(daysbox2);
		jp2.add(courseweekbox3);
		jp2.add(lab3);
		jp2.add(courseweekbox6);
		jp2.add(daysbox3);

		// ������ť
		addbut = new JButton("����");
		addbut.setFont(font1);
		addbut.setBounds(70, 10, 80, 36);
		// ������ť����¼�
		addbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkHadInput() == false) {
					JOptionPane.showMessageDialog(null, "��������ʧ�ܣ��������пγ���Ϣ�Ƿ���д����");
				}else if(coursedao.courseIsExisted(courseidtxt.getText())) {
					JOptionPane.showMessageDialog(null, "��������ʧ�ܣ����ſγ��Ѿ�������");
				}else {
					teacourse.setCourse_id(courseidtxt.getText());
					teacourse.setCourse_name(coursenametxt.getText());
					if (coursenumbox.getSelectedItem().toString().equals("1��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("2��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "��"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("3��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "��"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString() + "��"
								+ courseweekbox3.getSelectedItem().toString() + "-"
								+ courseweekbox6.getSelectedItem().toString() + "-"
								+ daysbox3.getSelectedItem().toString());
					}
					teacourse.setTeacher_id(teaidbox.getSelectedItem().toString().substring(0, 4));
					teacourse.setTeacher_name(teaidbox.getSelectedItem().toString().substring(4));
					teacourse.setClassroom(addressbox.getSelectedItem().toString());
					teacourse.setStu_major(majortxt.getText());
					coursedao.addTeaCourse(teacourse);
					JOptionPane.showMessageDialog(null, "�γ������ɹ�����Ϊ��רҵѧ�����ſγ�");

					// ����ѧ���ɼ�¼�룬�ɼ�����Ϊ�գ�ͨ��ѧ��רҵ�½�һ��ѧ���ճɼ�

					// ͨ����ʦ���̵�רҵ���ҳ�ѧ�� �����ֶ� ����ѧ��id ѧ���������� �γ̱�ţ��γ���ʦ�����ճɼ�
					/*
					 * v.add() 1.select stu_id,stu_name from stu_info where
					 * major='teacourse.getStu_major' 2.����һ������������ȡ�������Ͽγ̱�ţ��γ���ʦ���ճɼ���װ��
					 * 3.data.add(v)������stu_score�� 4.����ɼ���
					 * 
					 */
					Stu_course stucourse = new Stu_course();

					Vector studata = stuinfodao.Find_ID_Name(teacourse.getStu_major());
					for (int i = 0; i < studata.size(); i++) {
						Vector v = (Vector) studata.get(i);
						v.add(teacourse.getCourse_id());
						v.add(teacourse.getCourse_name());
						v.add("");
						// System.out.println(v);
						stuscoredao.SetCourse(v);// ����ѧ���ɼ���
						// ����ѧ���γ̱�
						stucourse.setStu_id(v.get(0).toString());
						stucourse.setClassroom(teacourse.getClassroom());
						stucourse.setStu_major(teacourse.getStu_major());
						stucourse.setCourse_date(teacourse.getCourse_date());
						stucourse.setTeacher_id(teacourse.getTeacher_id());
						stucourse.setTeacher_name(teacourse.getTeacher_name());
						stucourse.setCourse_id(teacourse.getCourse_id());
						stucourse.setCourse_name(teacourse.getCourse_name());

						coursedao.addStuCourse(stucourse);

					}
					// ˢ�±��
					setTable();
				}
			}
		});

		// ��ȡ��������ı�
		coursetable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {// �����±�Խ��
				courseidtxt.setText(coursetable.getValueAt(coursetable.getSelectedRow(), 0).toString());
				coursenametxt.setText(coursetable.getValueAt(coursetable.getSelectedRow(), 1).toString());
				// ����String�����ȡ�Ͽ�ʱ�䵽������
				String[] ary = coursetable.getValueAt(coursetable.getSelectedRow(), 2).toString().split("��");
				if (ary.length == 1) {
					coursenumbox.setSelectedItem("1��");
					for (int i = 0; i < ary.length; i++) {
						String[] week = ary[i].split("-");
						for (int j = 0; j < week.length; j++) {
							courseweekbox1.setSelectedItem(week[0]);
							courseweekbox4.setSelectedItem(week[1]);
							daysbox1.setSelectedItem(week[2]);
						}
					}
				} else if (ary.length == 2) {
					coursenumbox.setSelectedItem("2��");
					for (int i = 0; i < ary.length; i++) {
						String[] week = ary[i].split("-");
						if (i == 0) {
							for (int j = 0; j < week.length; j++) {
								courseweekbox1.setSelectedItem(week[0]);
								courseweekbox4.setSelectedItem(week[1]);
								daysbox1.setSelectedItem(week[2]);
							}
						} else if (i == 1) {
							for (int j = 0; j < week.length; j++) {
								courseweekbox2.setSelectedItem(week[0]);
								courseweekbox5.setSelectedItem(week[1]);
								daysbox2.setSelectedItem(week[2]);
							}
						}
					}
				} else if (ary.length == 3) {
					coursenumbox.setSelectedItem("3��");
					for (int i = 0; i < ary.length; i++) {
						String[] week = ary[i].split("-");
						if (i == 0) {
							for (int j = 0; j < week.length; j++) {
								courseweekbox1.setSelectedItem(week[0]);
								courseweekbox4.setSelectedItem(week[1]);
								daysbox1.setSelectedItem(week[2]);
							}
						} else if (i == 1) {
							for (int j = 0; j < week.length; j++) {
								courseweekbox2.setSelectedItem(week[0]);
								courseweekbox5.setSelectedItem(week[1]);
								daysbox2.setSelectedItem(week[2]);
							}
						} else if (i == 2) {
							for (int j = 0; j < week.length; j++) {
								courseweekbox3.setSelectedItem(week[0]);
								courseweekbox6.setSelectedItem(week[1]);
								daysbox3.setSelectedItem(week[2]);
							}
						}
					}
				}

				teaidbox.setSelectedItem(coursetable.getValueAt(coursetable.getSelectedRow(), 3).toString()
						+ coursetable.getValueAt(coursetable.getSelectedRow(), 4).toString());
				addressbox.setSelectedItem(coursetable.getValueAt(coursetable.getSelectedRow(), 5).toString());
				initMajor=coursetable.getValueAt(coursetable.getSelectedRow(), 6).toString();
				majortxt.setText(initMajor);
			}
		});

		// �޸İ�ť
		updatebut = new JButton("�޸�");
		updatebut.setFont(font1);
		updatebut.setBounds(70, 56, 80, 36);

		// �޸İ�ť����¼�
		updatebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkHadInput() == false) {
					JOptionPane.showMessageDialog(null, "�޸�����ʧ�ܣ��������пγ���Ϣ�Ƿ���д����");
				} else {
					teacourse.setCourse_id(courseidtxt.getText());
					teacourse.setTeacher_id(teaidbox.getSelectedItem().toString().substring(0, 4));
					teacourse.setTeacher_name(teaidbox.getSelectedItem().toString().substring(4));
					teacourse.setClassroom(addressbox.getSelectedItem().toString());

					if (coursenumbox.getSelectedItem().toString().equals("1��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("2��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "��"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("3��")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "��"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString() + "��"
								+ courseweekbox3.getSelectedItem().toString() + "-"
								+ courseweekbox6.getSelectedItem().toString() + "-"
								+ daysbox3.getSelectedItem().toString());
					}
					teacourse.setStu_major(majortxt.getText());
					coursedao.updateCourse(teacourse,initMajor);// �����ݿ��޸ĸ��ſγ���Ϣ
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					setTable();
				}

			}
		});
		// ɾ����ť
		deletebut = new JButton("ɾ��");
		deletebut.setFont(font1);
		deletebut.setBounds(70, 102, 80, 36);
		// ɾ����ť����¼�
		deletebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coursetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ��ɾ����");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ�����ſγ���", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						Object o = coursetable.getValueAt(coursetable.getSelectedRow(), 0);
						Object b = coursetable.getValueAt(coursetable.getSelectedRow(), 6);
						Object j = coursetable.getValueAt(coursetable.getSelectedRow(), 2);
						coursedao.deleteCourse(o.toString(), b.toString(), j.toString());
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
						setTable();
					}
				}
			}
		});

		//��ѯ���������¼�
		selectcoursetxt.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				//������ڰ��»س���ʵ�ֲ�ѯ����
				selectbut.doClick();
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		
		// ʵ������ť���
		jp3 = new JPanel();
		jp3.add(addbut);
		jp3.add(updatebut);
		jp3.add(deletebut);
		jp3.setLayout(null);
		jp3.setBounds(870, 375, 150, 180);

		this.add(selectcoursetxt);
		this.add(selectbut);
		this.add(coursejsp);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setLayout(null);

		this.setSize(1100, 600);

		this.setVisible(true);

	}

	public DefaultTableModel getModel() {
		// ���ر������
		Vector rowData = coursedao.getCourse(selectcoursetxt.getText());
		// ���ر�����
		Vector columnNames = coursedao.getColumnNames();
		// ʹ�ñ�����ݺͱ����⹹�����ģ��
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			// ��дDefaulttableModel��һ��������ʹ���ֻ�ܱ�ѡ�е��ǲ��ܱ༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// ˢ�±������
	public void setTable() {
		coursetable.setModel(getModel());
		// �����Ͽ�ʱ���п�
		TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
		dateColumn.setPreferredWidth(650);
	}

	// ˢ���������б�
	public void setJCombox() {
		Tea_infoDAO teainfodao = new Tea_infoDAO();
		Vector teaidname = teainfodao.getTeaId();
		teaidbox.setModel(new DefaultComboBoxModel(teaidname));
	}

	// ���������Ƿ��Ѿ���д
	public boolean checkHadInput() {
		boolean flag = false;
		// ��顰�γ̱�š������γ����ơ�����רҵ���ơ�������Ƿ�ȫ����д
		if (courseidtxt.getText().equals("") || coursenametxt.getText().equals("") || majortxt.getText().equals("")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
