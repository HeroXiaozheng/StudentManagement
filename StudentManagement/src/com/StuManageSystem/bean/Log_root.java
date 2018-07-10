package com.StuManageSystem.bean;

public class Log_root {
	private String usercode;
	private String pwd;

	public Log_root() {
	}

	public Log_root(String usercode, String pwd) {
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
