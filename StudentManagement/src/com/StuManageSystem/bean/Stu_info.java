package com.StuManageSystem.bean;

public class Stu_info {
	private String stu_id;
	private String stu_name;
	private String sex;
	private String birth;
	private String province;
	private String city;
	private String address;
	private String college;
	private String major;
	private String grade;
	private String stu_class;

	public Stu_info() {
	}

	public Stu_info(String stu_id, String stu_name, String sex, String birth, String province, String city,
			String address, String college, String major, String grade, String stu_class) {
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.sex = sex;
		this.birth = birth;
		this.province = province;
		this.city = city;
		this.address = address;
		this.college = college;
		this.major = major;
		this.grade = grade;
		this.stu_class = stu_class;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

}
