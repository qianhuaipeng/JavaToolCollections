package com.javase.reflect.proxy.impl;

import com.javase.reflect.proxy.Advice;

public class ControlAdvice implements Advice{

	@Override
	public void before() {
		System.out.println("before: " + System.nanoTime());
	}

	@Override
	public void after() {
		System.out.println("after: " + System.nanoTime());
	}
	
}
