package com.spring.springmvc.controller;

import org.springframework.stereotype.Component;

@Component
public class TestService {
	
	private int number;

	public int getNumber() {
		return number++;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
