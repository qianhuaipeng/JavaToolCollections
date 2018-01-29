package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.bean.SimpleHelloBean;
import com.spring.aop.service.IHelloService;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {
	
	/*Pointcut for sayHello*/
    @Pointcut("execution(* com.spring.aop.service.IHelloService.sayHello(..))")
    public void hellopoint() {

    }
    
    @Before("hellopoint()")
    public void beforehello() {
        System.out.println("接下去调用sayHello()......");
    }

    @After("hellopoint()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect executed");
    }

    @Around("hellopoint()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around start..");
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            System.out.println("error in around");
            throw ex;
        }
        System.out.println("around end");
    }

    @AfterReturning(pointcut = "hellopoint()",returning = "returnVal")
    public void afterhello(JoinPoint joinPoint, Object returnVal) {
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
