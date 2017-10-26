package com.task.controller;

import java.io.IOException;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.task.entity.User;
import com.task.services.UserService;

/**
 * 用户-控制器
 * @author ZDF
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService userService;
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@GetMapping("login")
	public String loginForm(){
		return "/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void LoginPost(
			@RequestParam String username, 
			@RequestParam String password,
			HttpSession session,HttpServletResponse response) {
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(password);
		User user1 = null;
		try{
		   user1 = userService.login(user);
		}catch(Exception e){
			 System.out.println("POST"+e);
		}
		HashMap<String,Object> retData = new HashMap<String,Object>();
		retData.put("retno", "1");
		if(user1 == null){
			retData.put("retno", "100");
		}else{
			session.setAttribute("user",user1);
			retData.put("retno", "0");
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
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@GetMapping("register")
	public String registerForm(){
		return "/register";
	}

	@GetMapping("home")
	public String home(){
		return "home";
	}
	
	@PostMapping("register")
	public void registerAction(
				@RequestParam String username, 
				@RequestParam String password, 
				HttpServletResponse response){
		
		if(StringUtils.isBlank(username)){
			printText(response, "用户名不能为空");
		}
		
		if(StringUtils.isBlank(password)){
			printText(response, "密码不能为空");
		}
		
		System.out.println("账户：" + username);
		System.out.println("密码：" + password);
		
		//userService.register(username, password);
		printText(response, "注册成功");
	}
	
}
