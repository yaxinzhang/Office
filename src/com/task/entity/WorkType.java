package com.task.entity;

import java.sql.Date;

public class WorkType {
	private int id;
	private String workName;
	private int userId;
	private int workTypeStatus;
	private Date createTime;
	private int state;
	private Date updateTime; 
	public Date getCreatetime() {
		return createTime;
	}
	public void setCreatetime(Date createtime) {
		this.createTime = createTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getUpdatetime() {
		return updateTime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updateTime = updatetime;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWorkTypeStatus() {
		return workTypeStatus;
	}
	public void setWorkTypeStatus(int workTypeStatus) {
		this.workTypeStatus = workTypeStatus;
	}
	
	//private Datetime workTypeDate;
}