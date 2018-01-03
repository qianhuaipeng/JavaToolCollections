package com.javase.reflect.proxy.impl;

import com.javase.reflect.proxy.SalaryInterface;

public class Salary implements SalaryInterface{

	@Override
	public void doSalary() {
		System.out.println("doSalary.....");
	}
	
}
