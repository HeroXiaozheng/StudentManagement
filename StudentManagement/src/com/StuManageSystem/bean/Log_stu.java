package com.StuManageSystem.bean;

public class Log_stu {

	private String usercode;
	private String pwd;

	public Log_stu() {

	}

	public Log_stu(String usercode, String pwd) {
		this.usercode = usercode;
		this.pwd = pwd;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
