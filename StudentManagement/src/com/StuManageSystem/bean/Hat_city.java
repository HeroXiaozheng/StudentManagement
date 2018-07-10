package com.StuManageSystem.bean;

public class Hat_city {
	private Integer cid;
	private String city;
	private String father;

	public Hat_city() {

	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public Hat_city(Integer cid, String city, String father) {
		this.cid = cid;
		this.city = city;
		this.father = father;
	}

}
