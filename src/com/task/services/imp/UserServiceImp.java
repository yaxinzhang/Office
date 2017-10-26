package com.task.services.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.task.entity.User;
import com.task.services.UserService;
import com.task.dao.UserDao;

@Service
public class UserServiceImp implements UserService{
	 @Resource
     UserDao userDao;
	 @Override
	 public User login(User user) {
		 	User u = userDao.login(user);
			return u;
		}
		
	
}
