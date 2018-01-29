package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.service.PersonService;

public class PersonAopTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:app.xml");
		PersonService service = ctx.getBean(PersonService.class);
		service.info();
		service.getName();
	}
}
