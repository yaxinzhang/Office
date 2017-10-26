package com.task.dao;

import com.task.entity.Business;
import com.task.entity.User;

public interface BusinessDao {
	//查询任务进度
	Business[] getInfos();
	//插入
	void addInfo(Business bs);
	//删除
	void delInfo(int id);
	//根据id查询
	Business[] getById(Business b);
	//修改
	void updateInfo(Business b);

}
