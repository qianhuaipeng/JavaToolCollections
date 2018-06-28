package com.javase.computation;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
	
	public static void main(String[] args) {
		System.out.println(10 & 11);
		
		int a = 1;
		int b = 2;
		a = 3;
		System.out.println(a + " " + b);
		
		HashMap hashMap = new HashMap();
		Map map = Collections.synchronizedMap(hashMap);
		
	}


	@Test
	public void test(){

	}
}
