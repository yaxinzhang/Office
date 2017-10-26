package com.task.dao;

import com.task.entity.WorkType;

public interface WorkTypeDao {

	//查询全部工作任务
	WorkType[] getInfos();
	//工作插入
	void addInfo(WorkType wt);
	//任务删除
	void delInfo(int id);
	//任务修改
	void updateInfo(WorkType wt);
	//根据工作名字查询
	WorkType[] getByWorkType(WorkType wt);
}
