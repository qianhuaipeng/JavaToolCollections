package com.javase.reflect.proxy;

import com.javase.reflect.proxy.impl.ControlAdvice;
import com.javase.reflect.proxy.impl.Salary;
import com.javase.reflect.proxy.impl.SimpleProxy;

public class Client {
	public static void main(String[] args) {
		SimpleProxy simpleProxy = new SimpleProxy();
		SalaryInterface salaryInterface = (SalaryInterface)simpleProxy.bind(new Salary(), new ControlAdvice());
		salaryInterface.doSalary();
	}
}
