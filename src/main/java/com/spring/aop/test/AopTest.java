package com.spring.aop.test;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.bean.SimpleHelloBean;
import com.spring.aop.service.IHelloService;

@Aspect
public class AopTest {
	
	/*Pointcut for sayHello*/
    @Pointcut("execution(* *.sayHello())")
    public void hellopoint() {
    	System.out.println("hellopoint");
    }
    
    @Before("hellopoint()")
    public void beforehello() {
        System.out.println("接下去调用sayHello()......");
    }
    
    @AfterReturning("hellopoint()")
    public void afterhello() {
        System.out.println("函数sayHello()执行结束......");
    }
    
    /*Pointcut for sayChinaHello*/
    @Pointcut("execution(* *.sayChinaHello())")
    public void helloChinapoint() {
    }
     
    @Before("helloChinapoint()")
    public void beforehelloChina() {
        System.out.println("接下去调用sayChinaHello()......");
    }
     
    @AfterReturning("helloChinapoint()")
    public void afterhelloChina() {
        System.out.println("函数sayChinaHello()执行结束......");
    }
    
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:app.xml");
    	//用接口
        IHelloService helloWorld = (IHelloService) ctx.getBean("helloService");
        helloWorld.sayHello();
        helloWorld.sayChinaHello();
        System.out.println("------------------------------------------------------------------------------------");
        //用类
        SimpleHelloBean SimpleHello = (SimpleHelloBean) ctx.getBean("SimpleHelloBean");
        SimpleHello.sayHello();
	}
}
