package com.StuManageSystem.bean;

public class Tea_info {
	private String teacher_id;
	private String teacher_name;
	private String sex;
	private String birth;
	private String province;
	private String city;
	private String college;
	private String major;
	private String address;

	public Tea_info() {

	}

	public Tea_info(String teacher_id, String teacher_name, String sex, String birth, String province, String city,
			String college, String major, String address) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.sex = sex;
		this.birth = birth;
		this.province = province;
		this.city = city;
		this.college = college;
		this.major = major;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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

}
