package com.task.dao;

import com.task.entity.User;

public interface UserDao {
	//增
	void insert(User user);
	//查
	User selectByUsername(String username);
	//改
	void update(User user);
	//删
	void delete(int id);
	
	//登录验证
	User login(User user1);

}
