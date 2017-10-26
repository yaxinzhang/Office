package com.task.entity;

import java.sql.Date;

public class Business {
	private int id; 
	private int workTypeId;
	private int businessStatus;
	private Date createtime;
	private int state;
	private Date updatetime; 
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	private String describes;
	public int getWorkTypeId() {
		return workTypeId;
	}
	public void setWorkTypeId(int workTypeId) {
		this.workTypeId = workTypeId;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(int businessStatus) {
		this.businessStatus = businessStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	
	

}
