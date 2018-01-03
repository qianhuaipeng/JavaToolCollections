package com.javase.reflect.test1;

import java.util.List;


public class PasswordUtils {
	
	@UserCase(id=47, description="Password must contain at leat one numeric")
	public boolean validatePassword(String password){
		System.out.println("validatePassword");
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UserCase(id= 48)
	public String encryptPassword(String password){
		System.out.println("encryptPassword");
		return new StringBuffer(password).reverse().toString();
	}
	
	@UserCase(id=49, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords,String password){
		System.out.println("checkForNewPassword");
		return !prevPasswords.contains(password);
	}
}
