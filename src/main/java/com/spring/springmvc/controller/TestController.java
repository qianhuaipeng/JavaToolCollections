package com.spring.springmvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * springmvc学习demo
 * 
 * @author Mike.Peng
 * @time Apr 1, 2016  11:07:22 AM
 */
@Scope("prototype")
@Controller
public class TestController {
    private static int num = 0;
    private int number = 0;
    @Autowired
    private TestService service;
	@ResponseBody
    @RequestMapping(value = "test1.do")	//项目访问路径为http://localhost/mvc/test.do?name=mike ，默认为GET方法
    public String test1(String name) {
    	return "测试内容 :: " + name;		//直接返回字符串
    }
	
	@ResponseBody
    @RequestMapping(value = "test.do")	
	public String test(){
		System.out.println(num++ + " | " + number++);
		int n = service.getNumber();
		System.out.println(n);
		return n+""; 
	}
}