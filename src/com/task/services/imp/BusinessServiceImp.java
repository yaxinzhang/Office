package com.task.services.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.task.entity.Business;
import com.task.services.BusinessService;
import com.task.dao.BusinessDao;

@Service
public class BusinessServiceImp implements BusinessService{
	 @Resource
	 BusinessDao BusinessDao;
	 //查询
	@Override
	public Business[] getBusinessInfos() {
		return BusinessDao.getInfos();
	}
	//添加
	@Override
	public void addBusinessInfo(Business bs) {
		BusinessDao.addInfo(bs);
		
	}
	//删除
	@Override
	public void delBusinessInfo(int id) {
		BusinessDao.delInfo(id);
		
	}
	//根据id查询
	@Override
	public Business[] getById(Business b) {
		return BusinessDao.getById(b);
	}
	//修改
	@Override
	public void updateBusinessInfo(Business b) {
		BusinessDao.updateInfo(b);
		
	}
		
	
}
