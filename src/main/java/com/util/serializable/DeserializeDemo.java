package com.util.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
	public static void main(String[] args) {
		String path = DeserializeDemo.class.getResource("/").getPath() + "person.ser";
		try {
			FileInputStream inputStream = new FileInputStream(path);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			Person person = (Person)input.readObject();
			input.close();
			inputStream.close();
			System.out.println(person.address);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
