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

//点击查询学生后中的修改页面
public class AdminStudentSeekSaveDialog extends JDialog {
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


	
	// 传过来的学生学号
	private String stuid;

	private JTable table;
	
	private Stu_infoDAO stuinfodao;
    private AdminStudentDAO adminstudao;
	
	
	
	public AdminStudentSeekSaveDialog(AdminMainFrame amf, String stuid, JTable table) {
		super(amf, true);

		this.stuid = stuid;
		this.table = table;
		
	

	
	

		// 学生操作实例化
		stuinfodao = new Stu_infoDAO();
		adminstudao = new AdminStudentDAO();

		Font font1 = new Font("微软雅黑", Font.BOLD, 20);

		stunamelab = new JLabel("姓名：");
		stunamelab.setFont(font1);
		stunamelab.setBounds(400, 20, 100, 50);

		stunametxt = new JTextField(16);
		stunametxt.setBounds(500, 25, 200, 40);

		stuidlab = new JLabel("学号：");
		stuidlab.setFont(font1);
		stuidlab.setBounds(400, 80, 100, 50);

		stuidtxt = new JTextField(16);
		stuidtxt.setBounds(500, 85, 200, 40);
		stuidtxt.setEditable(false);

		stusexlab = new JLabel("性别：");
		stusexlab.setFont(font1);
		stusexlab.setBounds(400, 140, 100, 50);

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

		stucollegelab = new JLabel("学院：");
		stucollegelab.setFont(font1);
		stucollegelab.setBounds(400, 200, 100, 50);
		stucollegetxt = new JTextField(16);
		stucollegetxt.setBounds(500, 205, 200, 40);

		stumajorlab = new JLabel("专业：");
		stumajorlab.setFont(font1);
		stumajorlab.setBounds(400, 260, 100, 50);
		stumajortxt = new JTextField(16);
		stumajortxt.setBounds(500, 265, 200, 40);

		stugradelab = new JLabel("年级：");
		stugradelab.setFont(font1);
		stugradelab.setBounds(400, 320, 100, 50);
		stugradetxt = new JTextField(16);
		stugradetxt.setBounds(460, 325, 100, 40);

		stuclasslab = new JLabel("班级：");
		stuclasslab.setFont(font1);
		stuclasslab.setBounds(570, 320, 100, 50);
		stuclasstxt = new JTextField(16);
		stuclasstxt.setBounds(630, 325, 100, 40);

		stubirthlab = new JLabel("出生日期：");
		stubirthlab.setFont(font1);
		stubirthlab.setBounds(400, 375, 100, 50);

		// 添加年下拉
		Vector vyear = new Vector();
		for (int i = 1979; i <= 2018; i++) {
			vyear.add(i);
		}
		yearbox = new JComboBox(vyear);
		yearbox.setBounds(500, 380, 60, 40);
		// 添加月下拉
		Vector vmonth = new Vector();
		for (int i = 1; i <= 12; i++) {
			vmonth.add(i);
		}
		monthbox = new JComboBox(vmonth);
		monthbox.setBounds(570, 380, 60, 40);
		// 添加日下拉
		Vector vday = new Vector();
		for (int i = 1; i <= 31; i++) {
			vday.add(i);
		}

		daybox = new JComboBox(vday);
		daybox.setBounds(640, 380, 60, 40);

		// 为月份添加事件，使天数随月数改变
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

		stuaddresslab = new JLabel("地址：");
		stuaddresslab.setFont(font1);
		stuaddresslab.setBounds(400, 495, 100, 50);

		stuaddresstxt = new JTextField(16);
		stuaddresstxt.setBounds(500, 500, 200, 40);

		savebutton = new JButton("保存");
		savebutton.setBounds(500, 580, 100, 50);

		// 初始学生界面显示

		/*
		 * 12345, 张三, 男, 1997, 河北, 石家庄, 幸福里, 信科院, 电信, 15, 3班
		 */
		Vector data = new Vector();
		data = adminstudao.seekStudent(stuid);

		stuidtxt.setText((String) data.get(0));
		stunametxt.setText((String) data.get(1));
		// 性别判断：
		String sex = data.get(2).toString();
		if (sex.equals("男")) {
			malebutton.setSelected(true);
		} else {
			femalebutton.setSelected(true);
		}
		// 出生日期，例如：1997-12-20
		String birth = (String) data.get(3);// 取出出生日期
		String year = birth.substring(0, 4);// 截取出年份
		// 截取出月份
		int str = birth.lastIndexOf("-");
		String month = birth.substring(5, str);

		yearbox.setSelectedItem(Integer.parseInt(year));
		monthbox.setSelectedIndex(Integer.parseInt(month) - 1);

		String day = birth.substring(str + 1);
		daybox.setSelectedItem(Integer.parseInt(day));

		// 显示省
		provincebox.setSelectedItem(data.get(4));

		// 显示市
		citybox.setSelectedItem(data.get(5));

		// 显示地址
		stuaddresstxt.setText(data.get(6).toString());

		// 显示学院

		stucollegetxt.setText(data.get(7).toString());

		// 显示专业

		stumajortxt.setText(data.get(8).toString());

		// 显示年级
		stugradetxt.setText(data.get(9).toString());

		// 显示班级
		stuclasstxt.setText(data.get(10).toString());

		// 保存按钮点击事件
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
				
				
				JOptionPane.showMessageDialog(null, "保存成功");
				dispose();

				// 重新建立表格
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

		this.setTitle("修改学生个人信息");
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
