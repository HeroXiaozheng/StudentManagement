package com.StuManageSystem.bean;

public class Log_tea {
	private String usercode;
	private String pwd;

	public Log_tea() {

	}

	public Log_tea(String usercode, String pwd) {
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
