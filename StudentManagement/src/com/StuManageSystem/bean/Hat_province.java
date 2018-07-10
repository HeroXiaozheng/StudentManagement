package com.StuManageSystem.bean;

public class Hat_province {
	private Integer sid;
	private String provinceid;
	private String province;

	public Hat_province() {

	}

	public Hat_province(Integer sid, String provinceid, String province) {
		this.sid = sid;
		this.provinceid = provinceid;
		this.province = province;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
