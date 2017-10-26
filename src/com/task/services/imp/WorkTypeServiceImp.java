package com.task.services.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.task.entity.WorkType;
import com.task.services.WorkTypeService;
import com.task.dao.WorkTypeDao;

@Service
public class WorkTypeServiceImp implements WorkTypeService{
	 @Resource
     WorkTypeDao worktypeDao;

	@Override
	public WorkType[] getWorktypeInfos() {
		return worktypeDao.getInfos();
	}

	@Override
	public void addWorkTypeInfos(WorkType wt) {
		worktypeDao.addInfo(wt);
		
	}

	@Override
	public void delByWorkIdInfos(int id) {
		worktypeDao.delInfo(id);
		
	}

	@Override
	public void updateByWorkIdInfos(WorkType wt) {
		worktypeDao.updateInfo(wt);
		
	}

	@Override
	public WorkType[] getByWorkTypeId(WorkType wt) {
		return worktypeDao.getByWorkType(wt);
		
	}

	
		
	
}

	

