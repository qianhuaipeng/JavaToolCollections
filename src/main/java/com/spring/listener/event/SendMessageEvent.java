package com.spring.listener.event;

import org.springframework.context.ApplicationEvent;

public class SendMessageEvent extends ApplicationEvent{
	private String phoneNum;
	public SendMessageEvent(Object source,String phoneNum) {
		super(source);
		this.phoneNum = phoneNum;
	}
	
	public String getPhoneNum() {
        return phoneNum;
    }
}
