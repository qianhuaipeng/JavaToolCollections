package com.spring.aop;

public class PersonAop {
	
	public void before_info() {
        System.out.println("接下去,调用info()显示人名......");
    }
    public void after_info() {
        System.out.println("调用info()结束......");
    }
    public void after_get() {
        System.out.println("调用getName()结束......");
    }
}
