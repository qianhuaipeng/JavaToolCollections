package com.spring.listener.test;

import java.util.ConcurrentModificationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.listener.service.UserService;

public class ListenerTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:app.xml");
		System.out.println(ac);
		UserService userService = ac.getBean(UserService.class);
		Long beginTime = System.currentTimeMillis();
		try {
			userService.doLogin("13381503500@163.com", "13381503500");
			System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		    System.out.println("处理其他业务逻辑");
		    Thread.sleep(500);//模拟处理其他业务请求耗时
		    System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		    System.out.println("向客户端发送注册成功响应");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
