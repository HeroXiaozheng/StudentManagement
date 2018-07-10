package com.StuManageSystem.bean;

public class Notice {
	private String title;
	private String notice_date;
	private String txt;

	public Notice() {

	}

	public Notice(String title, String notice_date, String txt) {
		this.title = title;
		this.notice_date = notice_date;
		this.txt = txt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

}
