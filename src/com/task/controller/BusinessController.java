package com.task.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.xmlrpc.base.Data;
import com.task.entity.Business;
import com.task.entity.User;
import com.task.entity.WorkType;
import com.task.services.BusinessService;
import com.task.services.WorkTypeService;
	/**
	 * 任务进
	 * @author 
	 *
	 */
	@Controller
	@RequestMapping("/business")
	public class BusinessController {

		@Resource
		BusinessService businessService;
		/**
		 * 
		 * @return
		 */
		@RequestMapping(value="/getbusinessinfos",method=RequestMethod.POST)
		//任务进度全部查询接口
		public void getworktypeinfos(HttpSession session,
				HttpServletResponse response){
			HashMap<String,Object> retData = new HashMap<String,Object>();
			retData.put("retno", "1");
			User user = (User) session.getAttribute("user");
			if(user != null){
				Business[] wts = null;
				try{
				wts = businessService.getBusinessInfos();
				}catch(Exception e){
					System.out.println(e);
				}
				retData.put("retno", "0");
				
				retData.put("result", wts);
			}else{
				retData.put("retno", "100");
			}
			System.out.println(JSON.toJSONString(retData));
			printText(response, JSON.toJSONString(retData));
		}
		//根据任务名字查询接口
		@RequestMapping(value="/getbyid",method=RequestMethod.POST)
				public void getByIdInfo(
						@RequestParam int id,
						HttpSession session,
						HttpServletResponse response){
					Business b=new Business();
					b.setWorkTypeId(id);
					HashMap<String,Object> retData = new HashMap<String,Object>();
					retData.put("retno", "1");
					User user = (User) session.getAttribute("user");
					if(user != null){
						Business[] wts = null;
						try{
						wts = businessService.getById(b);
						}catch(Exception e){
							System.out.println(e);
						}
						retData.put("retno", "0");
						retData.put("result", wts);
					}else{
						retData.put("retno", "100");
					}
					System.out.println(JSON.toJSONString(retData));
					printText(response, JSON.toJSONString(retData));
				}
		//进度任务插入
		@RequestMapping(value = "/addbusinessinfo", method = RequestMethod.POST)
		 public void addBusinessinfos(
				 @RequestParam int worktypeid, 
				 @RequestParam String describes, 
				 HttpSession session,
				HttpServletResponse response){
			 Business bs = new Business();
			 bs.setDescribes(describes);
			 bs.setWorkTypeId(worktypeid);
			 HashMap<String,Object> retData=new HashMap<String,Object>();
			 User user = (User) session.getAttribute("user");
			 if(user!= null){
				 try{
					 businessService.addBusinessInfo(bs);
				}catch(Exception e){
					 System.out.println("POST"+e);
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
		//进度任务的删除
		@RequestMapping(value="/delbusinessinfo",method=RequestMethod.POST)
		public void delbusinessinfo(
				@RequestParam String id,
				HttpSession session,
				HttpServletResponse response){
			HashMap<String,Object> retData=new HashMap<String,Object>();
			User user = (User) session.getAttribute("user");
			 if(user!= null){
				 try{
					 businessService.delBusinessInfo(Integer.parseInt(id));
				 }catch(Exception e){
					 System.out.println("POST"+e);
				}retData.put("retno", "0");
			}else{
				retData.put("retno", "100");
			}
			 System.out.println(JSON.toJSONString(retData));
			 printText(response, JSON.toJSONString(retData));
		}
		//修改
		@RequestMapping(value="/updatebusinessinfo",method=RequestMethod.POST)
		public void updatebusinessinfo(
				@RequestParam int id,
				@RequestParam int workid,
				@RequestParam String describes,
				HttpSession session,
				HttpServletResponse response){
			Business b=new Business();
			b.setId(id);
			b.setWorkTypeId(workid);
			b.setDescribes(describes);
			HashMap<String,Object> retData=new HashMap<String,Object>();
			User user = (User) session.getAttribute("user");
			 if(user!= null){
				 try{
					 businessService.updateBusinessInfo(b);
				 }catch(Exception e){
					 System.out.println("POST"+e);
				}retData.put("tetno", "0");
			}else{
				retData.put("tetno", "100");
			}
			 System.out.println(JSON.toJSONString(retData));
			 printText(response, JSON.toJSONString(retData));
		}
		
}
