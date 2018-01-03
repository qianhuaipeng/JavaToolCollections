package com.spring.aop.service;


public class PersonService {
	
	//@Value("name")
	private String name;
	 
    public void setName(String name) {
        this.name = name;
    }
     
    public void info(){
        System.out.println("此人姓名为："+name);
    }
     
    public String getName(){
        return name;
    }
}
