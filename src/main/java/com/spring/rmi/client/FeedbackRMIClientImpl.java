package com.spring.rmi.client;

import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 远程调用客户端，客户端的接口定义必须和服务端接口类定义一样
 * @author alan
 *
 * 2017-3-20 下午7:07:40
 */
public class FeedbackRMIClientImpl{

	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("classpath:configuration/rmi/rmi-client.xml");
		IFeedbackWebService service = null;
		service = (IFeedbackWebService) context.getBean("fbWebServiceProxy");
		try {
			service.setFeedback("1", "1", "hello world!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
