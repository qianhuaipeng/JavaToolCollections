package com.spring.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.listener.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
    @RequestMapping(value = "login.do")	
	public String login(String emailAddress,String phoneNum){
		try {
			Long beginTime = System.currentTimeMillis();
			userService.doLogin("13381503500@163.com", "13381503500");
			System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		    System.out.println("处理其他业务逻辑");
		    Thread.sleep(500);//模拟处理其他业务请求耗时
		    System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		    System.out.println("向客户端发送注册成功响应");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "login success... 10s automatically jump to the home page...";
	}
}
