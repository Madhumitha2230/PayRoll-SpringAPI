package com.payrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapp.model.User;
import com.payrollapp.repository.UserRepository;
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("users/save")//register 
	public User save(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@GetMapping("users/list")//list all employees
	public List<User>findAll(){
		List<User>userlist=userRepository.findAll();
		return userlist;
	}
	@PutMapping("users/{emp_id}")//update
	public void update(@PathVariable("emp_id")Integer empId,@RequestBody User user) {
		user.setEmpId(empId);
		userRepository.save(user);
	}
	
	@GetMapping("users/search/{designation}")//search by designation
	public List<User> findByDesignation(@PathVariable("designation")String designation) {
		
		List<User> userListByDesignation  ;
	
			userListByDesignation = userRepository.findByDesignation(designation);
			return userListByDesignation;
			
	
	}
	
}
