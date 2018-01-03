package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHelper implements ApplicationContextAware {
	private static ApplicationContext ac = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		ApplicationContextHelper.ac = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return ac;
	}
	
	public final static Object getBean(String beanName){
		return ac.getBean(beanName);
	}
	
	public final static Object getBean(String beanName,Class<?> requiredType){
		return ac.getBean(beanName, requiredType);
	}
}
