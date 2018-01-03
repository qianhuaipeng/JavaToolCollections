package com.spring.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class SimpleHelloBean {
	public void sayHello(){
        System.out.println("Hello World!");
    }
}
