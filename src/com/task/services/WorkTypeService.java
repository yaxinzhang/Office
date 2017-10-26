package com.task.services;

import com.task.entity.WorkType;

public interface WorkTypeService {
	
	//查询全部任务
	WorkType[] getWorktypeInfos();
	
	//根据工作名字查询
	WorkType[] getByWorkTypeId(WorkType wt);

	//插入
	void addWorkTypeInfos(WorkType wt);
	//删除
	void delByWorkIdInfos(int id);
	//修改
	void updateByWorkIdInfos(WorkType wt);
	
}
