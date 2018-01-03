package com.spring.listener.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent{
	//定义事件的核心成员：发送目的地，共监听器调用完成邮箱发送功能
    private String emailAddress;
	public SendEmailEvent(Object source,String emailAddress) {
		super(source);
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
        return emailAddress;
    }
}
