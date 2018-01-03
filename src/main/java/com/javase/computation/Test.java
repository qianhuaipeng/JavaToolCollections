package com.javase.computation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(10 & 11);
		
		int a = 1;
		int b = 2;
		a = 3;
		System.out.println(a + " " + b);
		
		HashMap hashMap = new HashMap();
		Map map = Collections.synchronizedMap(hashMap);
		
	}
}
