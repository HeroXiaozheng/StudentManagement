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

	private JLabel stunamelab;// 学生姓名
	private JLabel stuidlab;// 学生学号
	private JLabel stusexlab;// 学生性别
	private JLabel stubirthlab;// 学生生日
	private JLabel stucollegelab;// 学生学院
	private JLabel stugradelab;// 学生年级
	private JLabel stumajorlab;// 学生专业
	private JLabel stuclasslab;// 学生班级
	private JLabel stuplacelab;// 学生籍贯
	private JLabel stuaddresslab;// 学生地址

	
	
	private JLabel namewarn;// 姓名为空时的提示
	private JLabel numwarn;// 工号为空时的提示
	private JLabel majorwarn;// 专业为空时的提示
	private JLabel collegewarn;// 学院为空时的提示
	private JLabel gradewarn;// 年级为空时的提示
	private JLabel classwarn;// 班级为空时的提示
	private JLabel addresswarn;// 地址为空时的提示

	private JTextField stunametxt;// 姓名输入框
	private JTextField stuidtxt;// 学号输入框
	private JTextField stucollegetxt;// 学院输入框
	private JTextField stugradetxt;// 年级输入框
	private JTextField stumajortxt;// 专业输入框
	private JTextField stuclasstxt;// 班级输入框
	private JTextField stuaddresstxt;// 地址输入框

	private JRadioButton malebutton;// 单选男生按钮
	private JRadioButton femalebutton;// 单选女生按钮
	private ButtonGroup sexbg;

	private JComboBox yearbox;// 年下拉列表
	private JComboBox monthbox;// 月下拉列表
	private JComboBox daybox;// 日下拉列表
	private JComboBox provincebox;// 省份下拉列表
	private JComboBox citybox;// 城市下拉列表

	private JButton savebutton;// 保存按钮

	private Stu_infoDAO stuinfodao;
	
	public AdminStudentAdd() {

		stuinfodao = new Stu_infoDAO();
		
		
		Font font1 = new Font("微软雅黑", Font.BOLD, 20);
      
		// 姓名为空时的提示
		namewarn = new JLabel("姓名不能为空");
		namewarn.setBounds(710, 10, 100, 50);
		namewarn.setVisible(false);
		// 工号为空时的提示
		numwarn = new JLabel("学号不能为空");
		numwarn.setBounds(710, 70, 100, 50);
		numwarn.setVisible(false);
		// 学院为空时的提示
		collegewarn = new JLabel("学院不能为空");
		collegewarn.setBounds(710, 190, 100, 50);
		collegewarn.setVisible(false);
		// 专业为空时的提示
		majorwarn = new JLabel("专业不能为空");
		majorwarn.setBounds(710, 250, 100, 50);
		majorwarn.setVisible(false);
		// 年级为空时的提示
		gradewarn = new JLabel("年级不能为空");
		gradewarn.setBounds(460, 338, 100, 50);
		gradewarn.setVisible(false);
		// 班级为空时的提示
		classwarn = new JLabel("班级不能为空");
		classwarn.setBounds(730, 310, 100, 50);
		classwarn.setVisible(false);
		// 地址为空时的提示
		addresswarn = new JLabel("地址不能为空");
		addresswarn.setBounds(710, 485, 100, 50);
		addresswarn.setVisible(false);

		stunamelab = new JLabel("姓名：");
		stunamelab.setFont(font1);
		stunamelab.setBounds(400, 10, 100, 50);

		stunametxt = new JTextField(16);
		stunametxt.setBounds(500, 15, 200, 40);

		// 姓名输入框焦点事件
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

		stuidlab = new JLabel("学号：");
		stuidlab.setFont(font1);
		stuidlab.setBounds(400, 70, 100, 50);

		stuidtxt = new JTextField(16);
		stuidtxt.setBounds(500, 75, 200, 40);

		// 学号输入框焦点事件
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

		stusexlab = new JLabel("性别：");
		stusexlab.setFont(font1);
		stusexlab.setBounds(400, 130, 100, 50);

		sexbg = new ButtonGroup();
		malebutton = new JRadioButton("男");
		femalebutton = new JRadioButton("女");
		malebutton.setSelected(true);
		sexbg.add(malebutton);
		sexbg.add(femalebutton);
		malebutton.setBounds(500, 135, 70, 40);
		malebutton.setFont(font1);
		femalebutton.setBounds(630, 135, 70, 40);
		femalebutton.setFont(font1);

		stucollegelab = new JLabel("学院：");
		stucollegelab.setFont(font1);
		stucollegelab.setBounds(400, 190, 100, 50);
		stucollegetxt = new JTextField(16);
		stucollegetxt.setBounds(500, 195, 200, 40);

		// 学员输入框焦点事件
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

		stumajorlab = new JLabel("专业：");
		stumajorlab.setFont(font1);
		stumajorlab.setBounds(400, 250, 100, 50);
		stumajortxt = new JTextField(16);
		stumajortxt.setBounds(500, 255, 200, 40);

		// 学生专业输入框焦点事件
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

		stugradelab = new JLabel("年级：");
		stugradelab.setFont(font1);
		stugradelab.setBounds(400, 310, 100, 50);
		stugradetxt = new JTextField(16);
		stugradetxt.setBounds(460, 315, 100, 40);

		// 学生年级输入框焦点事件
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

		stuclasslab = new JLabel("班级：");
		stuclasslab.setFont(font1);
		stuclasslab.setBounds(570, 310, 100, 50);
		stuclasstxt = new JTextField(16);
		stuclasstxt.setBounds(630, 315, 100, 40);

		// 学生班级输入框焦点事件
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

		stubirthlab = new JLabel("出生日期：");
		stubirthlab.setFont(font1);
		stubirthlab.setBounds(400, 365, 100, 50);

		// 添加年下拉
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 370, 60, 40);
		// 添加月下拉
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {

			vmonth.add(i);

		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 370, 60, 40);
		// 添加日下拉
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {

			vday.add(i);

		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 370, 60, 40);

		// 为月份添加事件，是天数随月数改变
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
		stuplacelab = new JLabel("籍贯：");
		stuplacelab.setFont(font1);
		stuplacelab.setBounds(400, 425, 100, 50);

		provincebox = new JComboBox(new String[] { "请选择..." });
		provincebox.setBounds(500, 425, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox(new String[] { "请选择..." });
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
		stuaddresslab = new JLabel("地址：");
		stuaddresslab.setFont(font1);
		stuaddresslab.setBounds(400, 485, 100, 50);

		stuaddresstxt = new JTextField(16);
		stuaddresstxt.setBounds(500, 490, 200, 40);

		// 地址输入框焦点事件
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

		savebutton = new JButton("保存");
		savebutton.setBounds(500, 540, 100, 50);


		// 新增学生
		savebutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
            
				
				
				// 判断学生学号，得到vector返回结果，然后根据返回的是否为空来判断学号是否已被征用
				String stuid = stuidtxt.getText();
				Vector studata = stuinfodao.seekStu(stuid);
				// 文本框不能为空的判断
				if (provincebox.getSelectedItem().toString().equals("请选择...")) {
					JOptionPane.showMessageDialog(null, "请设置籍贯");
				} else if ((stuidtxt.getText().equals("")) || (stunametxt.getText().equals(""))
						|| (stuaddresstxt.getText().equals("")) || (stucollegetxt.getText().equals(""))
						|| (stumajortxt.getText().equals("")) || (stugradetxt.getText().equals(""))
						|| (stuclasstxt.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "新增学生请求失败，请检查信息是否全部填写完整");
				} else if (!studata.isEmpty()) {
					JOptionPane.showMessageDialog(null, "该学号已存在");
					// 释放掉
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

					JOptionPane.showMessageDialog(null, "新增学生成功");
				}

			}
		});
		
		
		
		// 清空信息按钮事件
		/*
		 * btnClear.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { int choice =
		 * JOptionPane.showConfirmDialog(null, "你确定要清空所有的输入框吗", "提示信息",
		 * JOptionPane.YES_NO_OPTION); while (choice == 0) { // 重置所有输入框
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
