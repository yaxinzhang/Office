package com.task.services;

import com.task.entity.Business;

public interface BusinessService {
	//查询
	Business[] getBusinessInfos();
	//增加
	void addBusinessInfo(Business bs);
	//删除
	void delBusinessInfo(int id);
	//根据id查询
	Business[] getById(Business b);
	//修改
	void updateBusinessInfo(Business b);
}
