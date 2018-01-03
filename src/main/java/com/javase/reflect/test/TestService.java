package com.javase.reflect.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestService {
	public static void main(String[] args) {
		File springConfigFile = new File("G:\\GitWorkspace\\ToolsCollection\\ToolCollection\\src\\main\\webapp\\WEB-INF\\classes\\com\\javase\\reflect\\app.properties");
        Properties springConfig= new Properties();
        try {
			springConfig.load(new FileInputStream(springConfigFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String className = (String) springConfig.get("className");
        String methodName = (String) springConfig.get("methodName");
       // System.out.println(className);
        Class clazz;
		try {
			clazz = Class.forName(className);
			Method method = clazz.getMethod(methodName);
			Constructor constructor = clazz.getConstructor();
			Object service = constructor.newInstance();
			method.invoke(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
}
