package com.javase.reflect.test;

import java.lang.reflect.Field;


public class ReflectTest {
	
	public static void main(String[] args) {
		try {
			Class class1 = Class.forName("com.javase.reflect.entity.User");
			Field field = class1.getDeclaredField("id");
			Object o = class1.newInstance();
			field.setAccessible(true);
			field.set(o, "123");
			System.out.println(field.get(o));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
