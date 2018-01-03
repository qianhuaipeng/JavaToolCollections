package com.spring.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 向所有订阅者发送订阅消息
 * @author alan
 *
 * 2017-2-28 下午4:09:45
 */
public class TopicSender {
	public static void main(String[] args) {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-send.xml");  
          
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("myJmsTemplate");  
        for (int i = 0; i < 10; i++) {  
            jmsTemplate.send(new MessageCreator() {  
                public Message createMessage(Session session) throws JMSException {  
                    TextMessage msg = session.createTextMessage();  
                    // 设置消息属性  
                    msg.setStringProperty("phrCode", "C001");  
                    // 设置消息内容  
                    msg.setText("Hello World!");  
                    return msg;  
                }  
            });  
        }  
    } 
}
