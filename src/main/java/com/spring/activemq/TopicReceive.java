package com.spring.activemq;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Service;


@Service
public class TopicReceive {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TopicReceive.class);
	/**
	 * 接受订阅消息方法
	 * @param message
	 * @throws JmsException
	 * @throws JMSException
	 */
	public void receive(TextMessage message) throws JmsException, JMSException {
		logger.debug(message.getText());
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-receive.xml");
		while (true) {
			
		}
	}
}
