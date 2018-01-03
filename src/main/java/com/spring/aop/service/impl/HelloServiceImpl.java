package com.spring.aop.service.impl;

import com.spring.aop.service.IHelloService;

public class HelloServiceImpl implements IHelloService{
	private String Hello;
    private String ChinaHello;
	@Override
	public void sayHello() {
		System.out.println(Hello);
	}

	@Override
	public void sayChinaHello() {
		System.out.println(ChinaHello);
	}

	public String getHello() {
		return Hello;
	}

	public void setHello(String hello) {
		Hello = hello;
	}

	public String getChinaHello() {
		return ChinaHello;
	}

	public void setChinaHello(String chinaHello) {
		ChinaHello = chinaHello;
	}
}
