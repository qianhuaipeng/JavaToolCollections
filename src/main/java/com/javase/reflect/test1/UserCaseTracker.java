package com.javase.reflect.test1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCaseTracker {
	public static void trackerUserCase(List<Integer> userCases, Class<?> clazz){
		for (Method m : clazz.getDeclaredMethods()) {
			UserCase uc = m.getAnnotation(UserCase.class);
			if (uc != null) {
				System.out.println("Found use case: " + uc.id() + " " + uc.description());
				userCases.remove(new Integer(uc.id()));
			}
		}
		
		for (int i : userCases) {
			System.out.println("warning: missing use case-" + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> userCases = new ArrayList<Integer>();
		System.out.println(Collections.addAll(userCases, 47,48,49,50));
		for (Integer integer : userCases) {
			System.out.println(integer);
		}
		trackerUserCase(userCases, PasswordUtils.class);
		for (Integer integer : userCases) {
			System.out.println(integer);
		}
	}
}
