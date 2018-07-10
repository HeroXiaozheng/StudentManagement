package com.StuManageSystem.bean;

public class Stu_course {
	private String course_id;
	private String course_name;
	private String course_date;
	private String teacher_id;
	private String teacher_name;
	private String classroom;
	private String stu_id;
	private String stu_major;

	public Stu_course() {

	}

	public Stu_course(String course_id, String course_date, String teacher_id, String teacher_name, String classroom) {
		this.course_id = course_id;
		this.course_date = course_date;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.classroom = classroom;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_date() {
		return course_date;
	}

	public void setCourse_date(String course_date) {
		this.course_date = course_date;
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

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_major() {
		return stu_major;
	}

	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}

}
