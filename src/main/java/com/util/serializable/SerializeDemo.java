package com.util.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	public static void main(String[] args) {
		Person person = new Person();
		person.name = "Reyan Ali";
		person.address = "Phokka Kuan, Ambehta Peer";
		person.SSN = 11122333;
		person.number = 101;
		try {
			String path = SerializeDemo.class.getResource("/").getPath();
			FileOutputStream outputStream = new FileOutputStream("/person.ser");
			ObjectOutputStream out = new ObjectOutputStream(outputStream);
			out.writeObject(outputStream);
			out.close();
			outputStream.close();
			System.out.println("serialized data is saved in /tmp/person.ser");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// 
			e.printStackTrace();
		} 
	}
}
