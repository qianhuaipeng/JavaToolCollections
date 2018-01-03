package com.spring.listener.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.spring.listener.event.SendEmailEvent;
import com.spring.listener.event.SendMessageEvent;
/**********方法一：实现除了通过实现ApplicationEventPublisherAware接口************/
@Component
public class UserService implements ApplicationEventPublisherAware{
	
	 private ApplicationEventPublisher applicationEventPublisher;//底层事件发布者
	 
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	 public void doLogin(String emailAddress,String phoneNum) throws InterruptedException{
	        Thread.sleep(200);//模拟用户注册的相关业务逻辑处理
	        System.out.println("注册成功！");
	        //下列向用户发送邮件
	        SendEmailEvent sendEmailEvent = new SendEmailEvent(this,emailAddress);//定义事件
	        SendMessageEvent sendMessageEvent = new SendMessageEvent(this, phoneNum);
	        applicationEventPublisher.publishEvent(sendEmailEvent);//发布事件
	        applicationEventPublisher.publishEvent(sendMessageEvent);
	 }
}
