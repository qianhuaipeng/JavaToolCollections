package com.util.serializable;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1005976425663753508L;
	public String name;
	public String address;
	public transient int SSN;
	public int number;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}
