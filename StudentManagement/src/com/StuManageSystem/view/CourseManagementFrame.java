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

	private JLabel couresidlab;// 课程编号
	private JLabel couresnamelab;// 课程名
	private JLabel courestealab;// 任课老师
	private JLabel couresclasslab;// 班级
	private JLabel couresaddresslab;// 教室
	private JLabel couresnumlab;// 节数
	private JLabel courestimelab1;// 上课时间
	private JLabel courestimelab2;// 上课时间
	private JLabel courestimelab3;// 上课时间
	private JLabel lab1;// 周数下拉框中间的“至”字
	private JLabel lab2;// 周数下拉框中间的“至”字
	private JLabel lab3;// 周数下拉框中间的“至”字

	private JTextField selectcoursetxt;// 查询框
	private JTextField courseidtxt;// 课程编号框
	private JTextField coursenametxt;// 课程名框
	private JTextField majortxt;// 专业名称框

	private JComboBox teaidbox;// 任课老师编号下拉框
	private JComboBox addressbox;// 教室下拉框
	private JComboBox coursenumbox;// 节数下拉框
	private JComboBox courseweekbox1;// 周数下拉框
	private JComboBox courseweekbox2;// 周数下拉框
	private JComboBox courseweekbox3;// 周数下拉框
	private JComboBox courseweekbox4;// 周数下拉框
	private JComboBox courseweekbox5;// 周数下拉框
	private JComboBox courseweekbox6;// 周数下拉框
	private JComboBox daysbox1;// 星期几第几节下拉框
	private JComboBox daysbox2;// 星期几第几节下拉框
	private JComboBox daysbox3;// 星期几第几节下拉框

	private JButton selectbut;// 查询按钮
	private JButton updatebut;// 修改按钮
	private JButton deletebut;// 删除按钮
	private JButton addbut;// 新增按钮

	private JPanel jp1;// 左侧输入框
	private JPanel jp2;// 中间输入框
	private JPanel jp3;// 右侧按钮

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

		Font font1 = new Font("微软雅黑", Font.PLAIN, 15);
		Font font2 = new Font("微软雅黑", Font.PLAIN, 20);

		// 添加搜索框
		selectcoursetxt = new JTextField(16);
		selectcoursetxt.setText("输入课程名称或者编号");
		selectcoursetxt.setFont(font1);
		selectcoursetxt.setBounds(380, 20, 220, 40);
		selectcoursetxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
			}

			public void focusGained(FocusEvent e) {
				selectcoursetxt.selectAll();
			}
		});

		// 添加查询按钮
		selectbut = new JButton("查询课程");
		selectbut.setBounds(610, 20, 120, 40);
		selectbut.setFont(font2);
		// 添加查询按钮点击事件
		selectbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetable.setModel(getModel());
				// 设置上课时间列宽
				TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
				dateColumn.setPreferredWidth(650);
			}
		});

		// 添加课程信息表
		coursetable = new JTable(this.getModel());
		coursetable.setRowHeight(25);
		coursejsp = new JScrollPane(coursetable);
		coursejsp.setBounds(10, 70, 1075, 300);
		// 设置上课时间列宽
		TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
		dateColumn.setPreferredWidth(650);

		couresidlab = new JLabel("课程编号：");
		couresidlab.setFont(font2);
		couresidlab.setBounds(10, 10, 100, 30);
		// couresnamelab;//课程名
		couresnamelab = new JLabel("课程名称：");
		couresnamelab.setFont(font2);
		couresnamelab.setBounds(10, 40, 100, 30);
		// courestealab;//任课老师
		courestealab = new JLabel("任课老师：");
		courestealab.setFont(font2);
		courestealab.setBounds(10, 70, 100, 30);
		// couresclasslab;//班级
		couresclasslab = new JLabel("专      业：");
		couresclasslab.setFont(font2);
		couresclasslab.setBounds(10, 100, 100, 30);
		// 地点
		couresaddresslab = new JLabel("教      室：");
		couresaddresslab.setFont(font2);
		couresaddresslab.setBounds(10, 130, 100, 30);
		// 课程编号框
		courseidtxt = new JTextField(16);
		courseidtxt.setBounds(110, 15, 200, 20);
		// 课程名框
		coursenametxt = new JTextField(16);
		coursenametxt.setBounds(110, 45, 200, 20);
		// 专业名称框
		majortxt = new JTextField(16);
		majortxt.setBounds(110, 105, 200, 20);

		// 任课老师编号下拉框
		teaidbox = new JComboBox();
		teaidbox.setBounds(110, 75, 200, 20);

		Tea_infoDAO teainfodao = new Tea_infoDAO();

		for (Object o : teainfodao.getTeaId()) {
			teaidbox.addItem(o);
		}

		// 教室下拉框
		String[] classroom = new String[20];
		for (int i = 0; i < 20; i++) {
			if (i < 9) {
				classroom[i] = "教室0" + (i + 1);
			} else {
				classroom[i] = "教室" + (i + 1);
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
		// 为文本框添加获得焦点时选中所有文字
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

		// 节数
		couresnumlab = new JLabel("一周节数：");
		couresnumlab.setFont(font2);
		couresnumlab.setBounds(10, 10, 100, 30);
		// 上课时间
		courestimelab1 = new JLabel("上课时间：");
		courestimelab1.setFont(font2);
		courestimelab1.setBounds(10, 40, 100, 30);
		// 上课时间
		courestimelab2 = new JLabel("上课时间：");
		courestimelab2.setFont(font2);
		courestimelab2.setBounds(10, 70, 100, 30);
		// 上课时间
		courestimelab3 = new JLabel("上课时间：");
		courestimelab3.setFont(font2);
		courestimelab3.setBounds(10, 100, 100, 30);

		// 节数下拉框
		coursenumbox = new JComboBox(new String[] { "请选择..(一周最多三节)", "1节", "2节", "3节" });
		coursenumbox.setBounds(110, 15, 360, 20);
		// 设置节数下拉框的监听事件
		coursenumbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (coursenumbox.getSelectedItem().toString().equals("请选择..(一周最多三节)")) {
					courseweekbox1.setEnabled(false);
					courseweekbox4.setEnabled(false);
					daysbox1.setEnabled(false);
					courseweekbox2.setEnabled(false);
					courseweekbox5.setEnabled(false);
					daysbox2.setEnabled(false);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("1节")) {
					courseweekbox1.setEnabled(true);
					courseweekbox4.setEnabled(true);
					daysbox1.setEnabled(true);
					courseweekbox2.setEnabled(false);
					courseweekbox5.setEnabled(false);
					daysbox2.setEnabled(false);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("2节")) {
					courseweekbox1.setEnabled(true);
					courseweekbox4.setEnabled(true);
					daysbox1.setEnabled(true);
					courseweekbox2.setEnabled(true);
					courseweekbox5.setEnabled(true);
					daysbox2.setEnabled(true);
					courseweekbox3.setEnabled(false);
					courseweekbox6.setEnabled(false);
					daysbox3.setEnabled(false);
				} else if (coursenumbox.getSelectedItem().toString().equals("3节")) {
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

		// 周数下拉框
		String[] week = new String[20];
		for (int i = 0; i < 20; i++) {
			if (i < 9) {
				week[i] = "第0" + (i + 1) + "周";
			} else {
				week[i] = "第" + (i + 1) + "周";
			}

		}
		courseweekbox1 = new JComboBox(week);
		courseweekbox1.setBounds(110, 45, 90, 20);
		lab1 = new JLabel("至");
		lab1.setBounds(200, 45, 20, 20);
		// 周数下拉框
		courseweekbox2 = new JComboBox(week);
		courseweekbox2.setBounds(110, 75, 90, 20);
		lab2 = new JLabel("至");
		lab2.setBounds(200, 75, 20, 20);
		// 周数下拉框
		courseweekbox3 = new JComboBox(week);
		courseweekbox3.setBounds(110, 105, 90, 20);
		lab3 = new JLabel("至");
		lab3.setBounds(200, 105, 20, 20);
		// 周数下拉框
		courseweekbox4 = new JComboBox(week);
		courseweekbox4.setBounds(212, 45, 90, 20);
		// 周数下拉框
		courseweekbox5 = new JComboBox(week);
		courseweekbox5.setBounds(212, 75, 90, 20);
		// 周数下拉框
		courseweekbox6 = new JComboBox(week);
		courseweekbox6.setBounds(212, 105, 90, 20);

		// 星期几第几节下拉框
		String[] days = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
		String[] classes = { "第一大节", "第二大节", "第三大节", "第四大节" };
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
		// 星期几第几节下拉框
		daysbox2 = new JComboBox(vclass);
		daysbox2.setBounds(305, 75, 165, 20);
		// 星期几第几节下拉框
		daysbox3 = new JComboBox(vclass);
		daysbox3.setBounds(305, 105, 165, 20);
		// 判断上课周数的设置（前一个框的周数不能大于后一个框
		courseweekbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			    int num1 = Integer.parseInt((courseweekbox1.getSelectedItem().toString().substring(1, 3)));
				System.out.println(num1);
			    int num2 = Integer.parseInt((courseweekbox4.getSelectedItem().toString().substring(1, 3)));
				int num3 = Integer.parseInt((courseweekbox2.getSelectedItem().toString().substring(1, 3)));
				int num4 = Integer.parseInt((courseweekbox5.getSelectedItem().toString().substring(1, 3)));
				int num5 = Integer.parseInt((courseweekbox3.getSelectedItem().toString().substring(1, 3)));

				int num6 = Integer.parseInt((courseweekbox6.getSelectedItem().toString().substring(1, 3)));
				if (coursenumbox.getSelectedItem().toString().equals("1节")) {
					if (num1 > num2) {
						JOptionPane.showMessageDialog(null, "上课周数设置有误，请重新设置");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("2节")) {
					if (num1 > num2 || num3 > num4) {
						JOptionPane.showMessageDialog(null, "上课周数设置有误，请重新设置");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("3节")) {
					if (num1 > num2 || num3 > num4 || num5 > num6) {
						JOptionPane.showMessageDialog(null, "上课周数设置有误，请重新设置");
					}
				}

			}
		});

		daysbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s1 = daysbox1.getSelectedItem().toString();
				String s2 = daysbox2.getSelectedItem().toString();
				String s3 = daysbox3.getSelectedItem().toString();
				if (coursenumbox.getSelectedItem().toString().equals("2节")) {
					if (s2.equals(s1)) {
						JOptionPane.showMessageDialog(null, "上课时间设置有误，请重新设置");
					}
				} else if (coursenumbox.getSelectedItem().toString().equals("3节")) {
					if (s2.equals(s1) || s2.equals(s3) || s3.equals(s1)) {
						JOptionPane.showMessageDialog(null, "上课时间设置有误，请重新设置");
					}
				}

			}
		});
		daysbox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s1 = daysbox1.getSelectedItem().toString();
				String s2 = daysbox2.getSelectedItem().toString();
				String s3 = daysbox3.getSelectedItem().toString();
				if (coursenumbox.getSelectedItem().toString().equals("3节")) {
					if (s2.equals(s1) || s2.equals(s3) || s3.equals(s1)) {
						JOptionPane.showMessageDialog(null, "上课时间设置有误，请重新设置");
					}
				}

			}
		});

		// 设置上课时间的所有下拉框初始为不可获取enable
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

		// 新增按钮
		addbut = new JButton("新增");
		addbut.setFont(font1);
		addbut.setBounds(70, 10, 80, 36);
		// 新增按钮点击事件
		addbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkHadInput() == false) {
					JOptionPane.showMessageDialog(null, "新增请求失败，请检查所有课程信息是否填写完整");
				}else if(coursedao.courseIsExisted(courseidtxt.getText())) {
					JOptionPane.showMessageDialog(null, "新增请求失败，该门课程已经存在了");
				}else {
					teacourse.setCourse_id(courseidtxt.getText());
					teacourse.setCourse_name(coursenametxt.getText());
					if (coursenumbox.getSelectedItem().toString().equals("1节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("2节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "、"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("3节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "、"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString() + "、"
								+ courseweekbox3.getSelectedItem().toString() + "-"
								+ courseweekbox6.getSelectedItem().toString() + "-"
								+ daysbox3.getSelectedItem().toString());
					}
					teacourse.setTeacher_id(teaidbox.getSelectedItem().toString().substring(0, 4));
					teacourse.setTeacher_name(teaidbox.getSelectedItem().toString().substring(4));
					teacourse.setClassroom(addressbox.getSelectedItem().toString());
					teacourse.setStu_major(majortxt.getText());
					coursedao.addTeaCourse(teacourse);
					JOptionPane.showMessageDialog(null, "课程新增成功，已为该专业学生安排课程");

					// 连接学生成绩录入，成绩设置为空，通过学生专业新建一个学生空成绩

					// 通过老师所教的专业查找出学生 所需字段 ：（学生id 学生姓名）（ 课程编号，课程老师），空成绩
					/*
					 * v.add() 1.select stu_id,stu_name from stu_info where
					 * major='teacourse.getStu_major' 2.将第一步的数据逐条取出，加上课程编号，课程老师，空成绩封装好
					 * 3.data.add(v)，放入stu_score中 4.插入成绩表
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
						stuscoredao.SetCourse(v);// 操作学生成绩表
						// 操作学生课程表
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
					// 刷新表格
					setTable();
				}
			}
		});

		// 获取点击表格的文本
		coursetable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {// 数组下标越界
				courseidtxt.setText(coursetable.getValueAt(coursetable.getSelectedRow(), 0).toString());
				coursenametxt.setText(coursetable.getValueAt(coursetable.getSelectedRow(), 1).toString());
				// 创建String数组获取上课时间到下拉框
				String[] ary = coursetable.getValueAt(coursetable.getSelectedRow(), 2).toString().split("、");
				if (ary.length == 1) {
					coursenumbox.setSelectedItem("1节");
					for (int i = 0; i < ary.length; i++) {
						String[] week = ary[i].split("-");
						for (int j = 0; j < week.length; j++) {
							courseweekbox1.setSelectedItem(week[0]);
							courseweekbox4.setSelectedItem(week[1]);
							daysbox1.setSelectedItem(week[2]);
						}
					}
				} else if (ary.length == 2) {
					coursenumbox.setSelectedItem("2节");
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
					coursenumbox.setSelectedItem("3节");
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

		// 修改按钮
		updatebut = new JButton("修改");
		updatebut.setFont(font1);
		updatebut.setBounds(70, 56, 80, 36);

		// 修改按钮点击事件
		updatebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkHadInput() == false) {
					JOptionPane.showMessageDialog(null, "修改请求失败，请检查所有课程信息是否填写完整");
				} else {
					teacourse.setCourse_id(courseidtxt.getText());
					teacourse.setTeacher_id(teaidbox.getSelectedItem().toString().substring(0, 4));
					teacourse.setTeacher_name(teaidbox.getSelectedItem().toString().substring(4));
					teacourse.setClassroom(addressbox.getSelectedItem().toString());

					if (coursenumbox.getSelectedItem().toString().equals("1节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("2节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "、"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString());
					} else if (coursenumbox.getSelectedItem().toString().equals("3节")) {
						teacourse.setCourse_date(courseweekbox1.getSelectedItem().toString() + "-"
								+ courseweekbox4.getSelectedItem().toString() + "-"
								+ daysbox1.getSelectedItem().toString() + "、"
								+ courseweekbox2.getSelectedItem().toString() + "-"
								+ courseweekbox5.getSelectedItem().toString() + "-"
								+ daysbox2.getSelectedItem().toString() + "、"
								+ courseweekbox3.getSelectedItem().toString() + "-"
								+ courseweekbox6.getSelectedItem().toString() + "-"
								+ daysbox3.getSelectedItem().toString());
					}
					teacourse.setStu_major(majortxt.getText());
					coursedao.updateCourse(teacourse,initMajor);// 向数据库修改该门课程信息
					JOptionPane.showMessageDialog(null, "修改成功");
					setTable();
				}

			}
		});
		// 删除按钮
		deletebut = new JButton("删除");
		deletebut.setFont(font1);
		deletebut.setBounds(70, 102, 80, 36);
		// 删除按钮点击事件
		deletebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coursetable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "请选择一行删除！");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "您确定删除该门课程吗", "提示信息", JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						Object o = coursetable.getValueAt(coursetable.getSelectedRow(), 0);
						Object b = coursetable.getValueAt(coursetable.getSelectedRow(), 6);
						Object j = coursetable.getValueAt(coursetable.getSelectedRow(), 2);
						coursedao.deleteCourse(o.toString(), b.toString(), j.toString());
						JOptionPane.showMessageDialog(null, "删除成功!");
						setTable();
					}
				}
			}
		});

		//查询输入框键盘事件
		selectcoursetxt.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				//输入框内按下回车键实现查询功能
				selectbut.doClick();
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		
		// 实例化按钮面板
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
		// 返回表格数据
		Vector rowData = coursedao.getCourse(selectcoursetxt.getText());
		// 返回表格标题
		Vector columnNames = coursedao.getColumnNames();
		// 使用表格数据和表格标题构建表格模型
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
			// 重写DefaulttableModel中一个方法，使表格只能被选中但是不能编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		return model;
	}

	// 刷新表格数据
	public void setTable() {
		coursetable.setModel(getModel());
		// 设置上课时间列宽
		TableColumn dateColumn = coursetable.getColumnModel().getColumn(2);
		dateColumn.setPreferredWidth(650);
	}

	// 刷新下拉框列表
	public void setJCombox() {
		Tea_infoDAO teainfodao = new Tea_infoDAO();
		Vector teaidname = teainfodao.getTeaId();
		teaidbox.setModel(new DefaultComboBoxModel(teaidname));
	}

	// 检查输入框是否已经填写
	public boolean checkHadInput() {
		boolean flag = false;
		// 检查“课程编号”、“课程名称”、“专业名称”输入框是否全部填写
		if (courseidtxt.getText().equals("") || coursenametxt.getText().equals("") || majortxt.getText().equals("")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
