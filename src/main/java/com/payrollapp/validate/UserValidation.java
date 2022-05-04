package com.payrollapp.validate;

import com.payrollapp.model.User;

public class UserValidation {
	
	public static void validate(User user) throws Exception {
		if(user.getName()==null||user.getName().trim()=="") {
			throw new Exception("Invalid name");
		}
		if(user.getEmail()==null||user.getEmail().trim()=="") {
			throw new Exception("Invalid Email");
		}
		else if(user.getEmail().contains("@")) {
			throw new Exception("Email should contain @");
		}
		if(user.getPassword()==null||user.getPassword().trim()=="") {
			throw new Exception("Invalid Password");
		}
		else if(user.getPassword().length()<8) {
			throw new Exception("pasword shoud contain 8 digits");
		}
		if(user.getDob()==null) {
			throw new Exception("Invalid Date");
		}

		if(user.getDesignation()==null||user.getDesignation().trim()=="") {
			throw new Exception("Invalid Designation");
		}

		if(user.getDateOfJoining()==null) {
			throw new Exception("Invalid name");
		}
	}
	public static void validateLogin(User userLogin) throws Exception {
		if (userLogin.getEmail() == null || userLogin.getEmail().trim().equals("")) {
			throw new Exception("Invalid email");
		} else if (!userLogin.getEmail().contains("@")) {
			throw new Exception("Email should contain @");
		}
		if (userLogin.getPassword() == null || userLogin.getPassword().trim().equals("")) {
			throw new Exception("Invalid password");
		} 
	}











}
