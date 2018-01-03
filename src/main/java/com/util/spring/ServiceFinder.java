/*
 * Power by www.xiaoi.com
 */
package com.util.spring;

import org.springframework.web.context.ContextLoader;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Sep 12, 2015 8:58:17 PM
 * @version 1.0
 */
public class ServiceFinder {

	public static <T>T getBean(Class<T> clazz){
		return ContextLoader.getCurrentWebApplicationContext().getBean(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static <T>T getBean(String name){
		return (T) ContextLoader.getCurrentWebApplicationContext().getBean(name);
	}
}
