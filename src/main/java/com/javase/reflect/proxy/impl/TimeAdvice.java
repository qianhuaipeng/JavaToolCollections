package com.javase.reflect.proxy.impl;

import com.javase.reflect.proxy.Advice;

public class TimeAdvice implements Advice{
	private long startTime;
	private long endTime;
	
	@Override
	public void before() {
		startTime = System.nanoTime();//获取开始时间
	}

	@Override
	public void after() {
		endTime = System.nanoTime();//获取结束时间
	}
	
}
