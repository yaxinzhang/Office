package com.task.entity;

import java.sql.Date;

public class User {
	private  int id;
	private String userName;
	private String userPassword;
	private int   userStatus;      
	private int   workType_id; 
	private Date createtime;
	private int state;
	private Date updatetime; 
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getWorkType_id() {
		return workType_id;
	}
	public void setWorkType_id(int workType_id) {
		this.workType_id = workType_id;
	}
	 
	//private Datetime userDate;
}
