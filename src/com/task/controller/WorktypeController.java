package com.task.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.sql.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.task.entity.Business;
import com.task.entity.User;
import com.task.entity.WorkType;
import com.task.services.UserService;
import com.task.services.WorkTypeService;



/**
 * 用户-控制器
 * @author ZDF
 *
 */
@Controller
@RequestMapping("/worktype")
public class WorktypeController {

	@Resource
	WorkTypeService worktypeService;

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/getworktypeinfos", method = RequestMethod.POST)
	//任务查询接口
	public void getworktypeinfos(HttpSession session,
			HttpServletResponse response){
		HashMap<String,Object> retData = new HashMap<String,Object>();
		retData.put("retno", "1");
		User user = (User) session.getAttribute("user");
		System.out.println("ee");
		if(user != null){
			WorkType[] wts = null;
			try{
			wts = worktypeService.getWorktypeInfos();
			}catch(Exception e){
				System.out.println(e);
			}
			retData.put("retno", "0");
			retData.put("result", wts);
			
		}else{
			retData.put("retno", "100");
		}
		System.out.println(JSON.toJSONString(retData));
		printText(response, JSON.toJSONString(retData));;
	}
	//任务根据id查询接口
	@RequestMapping(value="/getbyworktypeid", method = RequestMethod.POST)
		public void getbyworktypename(
				@RequestParam int workid,
				HttpSession session,
				HttpServletResponse response){
			WorkType wt=new WorkType();
			wt.setId(workid);
			HashMap<String,Object> retData = new HashMap<String,Object>();
			retData.put("retno", "1");
			User user = (User) session.getAttribute("user");
			System.out.println("ee");
			if(user != null){
				WorkType[] wts = null;
				try{
				wts = worktypeService.getByWorkTypeId(wt);
				}catch(Exception e){
					System.out.println(e);
				}
				retData.put("retno", "0");
				retData.put("result", wts);
			}else{
				retData.put("retno", "100");
			}
			System.out.println(JSON.toJSONString(retData));
			printText(response, JSON.toJSONString(retData));;
		}
	//插入
	@RequestMapping(value = "/addwork", method = RequestMethod.POST)
	 public void addworktypeinfos(
			 @RequestParam String workname, 
			 HttpSession session,
			HttpServletResponse response){
		HashMap<String,Object> retData= new HashMap<String,Object>();
		 User user = (User) session.getAttribute("user");
		 WorkType wt = new WorkType();
		 wt.setWorkName(workname);
		 wt.setUserId(user.getId());
		 if(user!= null){
			 try{
			 worktypeService.addWorkTypeInfos(wt);
			}catch(Exception e){
				 System.out.println(e);
			}retData.put("retno", "0");
		}else{
			retData.put("retno", "100");
		}
		 System.out.println(JSON.toJSONString(retData));
		 printText(response, JSON.toJSONString(retData));
		}
	
	private void printText(HttpServletResponse response, String text){
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//删除
	@RequestMapping(value = "/delwork", method = RequestMethod.POST)
	public void delworktypeinfos(@RequestParam String workid,
			HttpSession session,
			HttpServletResponse response){
		HashMap<String,Object> retData=new HashMap<String,Object>();
		User user = (User) session.getAttribute("user");
		 if(user!= null){
			 try{
		 worktypeService.delByWorkIdInfos(Integer.parseInt(workid));
			 }catch(Exception e){
				 System.out.println("POST"+e);
			}
			 retData.put("retno", "o");
		}else{
			retData.put("retno", "100");
		}
		 System.out.println(JSON.toJSONString(retData));
		 printText(response, JSON.toJSONString(retData));
	}
	//修改
		@RequestMapping(value ="updatework", method = RequestMethod.POST)
		public void updateworktypeinfos(
				@RequestParam int id, 
				@RequestParam String workname, 
				HttpSession session,
				HttpServletResponse response){
			HashMap<String,Object> retData=new HashMap<String,Object>();
			 WorkType wt = new WorkType();
			 wt.setWorkName(workname);
			 wt.setId(id);
			 User user = (User) session.getAttribute("user");
			 if(user!= null){
				 try{
			worktypeService.updateByWorkIdInfos(wt);
				 }catch(Exception e){
					 System.out.println("POST"+e);
				}retData.put("retno", "o");
			}else{
				retData.put("retno", "100");
			}
			 System.out.println(JSON.toJSONString(retData));
			 printText(response, JSON.toJSONString(retData));

		}
}