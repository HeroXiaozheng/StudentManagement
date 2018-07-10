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

	

	private JLabel teaname;// 老师姓名
	private JLabel teanum;// 老师工号
	private JLabel teasex;// 老师性别
	private JLabel teadate;// 老师出生日期
	private JLabel teaplace;// 老师籍贯
	private JLabel teacollege;// 老师学院
	private JLabel teamajor;// 老师专业
	private JLabel teaaddress;// 老师地址

	private JLabel namewarn;// 姓名为空时的提示
	private JLabel numwarn;// 工号为空时的提示
	private JLabel majorwarn;// 专业为空时的提示
	private JLabel collegewarn;// 学院为空时的提示
	private JLabel addresswarn;// 地址为空时的提示

	private JTextField teanametxt;// 老师姓名输入框
	private JTextField teanumtxt;// 老师工号输入框
	private JTextField teamajortxt;// 专业输入框
	private JTextField teacollegetxt;// 学院输入框
	private JTextField teaaddresstxt;// 地址输入框

	private JRadioButton malebutton;// 单选男生按钮
	private JRadioButton femalebutton;// 单选女生按钮
	private ButtonGroup sexbg;

	private JComboBox yearbox;// 老师任职年份下拉选项
	private JComboBox monthbox;// 老师任职月份下拉选项
	private JComboBox daybox;// 老师任职日下拉选项
	private JComboBox provincebox;// 老师省份下拉选项
	private JComboBox citybox;// 老师市级下拉选项

	private JButton saveteainfo;// 保存按钮
	private JButton btnClear;// 清空老师信息按钮
    
	
	public AdminTeacherAdd() {

		// backimage = new JLabel(new ImageIcon("image/back.jpg"));
		// backimage.setBounds(0, 0, 1100, 600);

		Font font1 = new Font("微软雅黑", Font.BOLD, 20);
    
		
		// 姓名为空时的提示
		namewarn = new JLabel("姓名不能为空");
		namewarn.setBounds(710, 20, 100, 50);
		namewarn.setVisible(false);
		// 工号为空时的提示
		numwarn = new JLabel("工号不能为空");
		numwarn.setBounds(710, 80, 100, 50);
		numwarn.setVisible(false);
		// 学院为空时的提示
		collegewarn = new JLabel("学院不能为空");
		collegewarn.setBounds(710, 205, 100, 50);
		collegewarn.setVisible(false);
		// 专业为空时的提示
		majorwarn = new JLabel("专业不能为空");
		majorwarn.setBounds(710, 265, 100, 50);
		majorwarn.setVisible(false);
		
		// 地址为空时的提示
		addresswarn = new JLabel("地址不能为空");
		addresswarn.setBounds(710, 435, 100, 50);
		addresswarn.setVisible(false);

		teaname = new JLabel("姓名：");
		teaname.setFont(font1);
		teaname.setBounds(400, 20, 100, 50);

		teanametxt = new JTextField(16);
		teanametxt.setBounds(500, 25, 200, 40);

		// 姓名输入框焦点事件
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

		teanum = new JLabel("工号：");
		teanum.setFont(font1);
		teanum.setBounds(400, 80, 100, 50);

		teanumtxt = new JTextField(16);
		teanumtxt.setBounds(500, 85, 200, 40);

		// 工号输入框点击事件
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

		teasex = new JLabel("性别：");
		teasex.setFont(font1);
		teasex.setBounds(400, 140, 100, 50);

		sexbg = new ButtonGroup();
		malebutton = new JRadioButton("男");
		femalebutton = new JRadioButton("女");
		malebutton.setSelected(true);
		sexbg.add(malebutton);
		sexbg.add(femalebutton);
		malebutton.setBounds(500, 145, 70, 40);
		malebutton.setFont(font1);
		femalebutton.setBounds(630, 145, 70, 40);
		femalebutton.setFont(font1);

		teacollege = new JLabel("学院：");
		teacollege.setFont(font1);
		teacollege.setBounds(400, 200, 100, 50);
		teacollegetxt = new JTextField(16);
		teacollegetxt.setBounds(500, 205, 200, 40);

		// 学院输入框焦点事件
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

		teamajor = new JLabel("专业：");
		teamajor.setFont(font1);
		teamajor.setBounds(400, 260, 100, 50);
		teamajortxt = new JTextField(16);
		teamajortxt.setBounds(500, 265, 200, 40);

		// 专业输入框点击事件
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

		teadate = new JLabel("出生日期：");
		teadate.setFont(font1);
		teadate.setBounds(400, 320, 100, 50);
		// 添加年下拉
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 325, 60, 40);
		// 添加月下拉
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {
			vmonth.add(i);
		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 325, 60, 40);
		// 添加日下拉
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {
			vday.add(i);
		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 325, 60, 40);

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

		teaplace = new JLabel("籍贯：");
		teaplace.setFont(font1);
		teaplace.setBounds(400, 375, 100, 50);

		provincebox = new JComboBox(new String[] { "请选择..." });
		provincebox.setBounds(500, 380, 95, 40);

		ProvinceDAO provincedao = new ProvinceDAO();
		Hat_province hatprovince = new Hat_province();

		for (Object o : provincedao.getProvince()) {
			provincebox.addItem(o);
		}
		citybox = new JComboBox(new String[] { "请选择..." });
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

		teaaddress = new JLabel("地址：");
		teaaddress.setFont(font1);
		teaaddress.setBounds(400, 435, 100, 50);

		teaaddresstxt = new JTextField(16);
		teaaddresstxt.setBounds(500, 440, 200, 40);

		// 地址输入框点击事件
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

		saveteainfo = new JButton("保存");
		saveteainfo.setBounds(500, 530, 100, 50);
		
		// 保存按钮点击事件
		saveteainfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 //照片判断
			
				
				
				
				// 得到工号,根据工号搜索内容，判断工号是否重复
				String teaid = teanumtxt.getText();
				Tea_infoDAO teadao = new Tea_infoDAO();
				Vector teadata = teadao.seekTea(teaid);
				// 判断内容不为空
				if (provincebox.getSelectedItem().toString().equals("请选择...")) {
					JOptionPane.showMessageDialog(null, "请设置籍贯");
				} else if ((teanumtxt.getText().equals("")) || (teanametxt.getText().equals(""))
						|| (teaaddresstxt.getText().equals("")) || (teacollegetxt.getText().equals(""))
						|| (teamajortxt.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "新增老师请求失败，请检查信息是否全部填写完整");
				} else if (!teadata.isEmpty()) {
					JOptionPane.showMessageDialog(null, "该工号已经存在");
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
					teainfodao.saveTea_info(teainfo);// 执行操作，往数据库添加信息
					 
			      
					JOptionPane.showMessageDialog(null, "保存成功");
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
