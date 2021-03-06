package com.payrollapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapp.model.User;
import com.payrollapp.repository.UserRepository;
import com.payrollapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserService userService;

	@PostMapping("users/save") // register
	public ResponseEntity<String> save(@RequestBody User user) throws Exception {
		try {
		userService.save(user);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		}
	@PostMapping("users/login")
	public ResponseEntity<String> login(@RequestBody User user) throws Exception {
		try {
			userService.login(user);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("users/list") // list all employees
	public List<User> findAll() {
		List<User> userlist = userRepository.findAll();
		return userlist;
	}

	@PutMapping("users/update/{emp_id}") // update
	public void update(@PathVariable("emp_id") Integer empId, @RequestBody User user) {
		user.setEmpId(empId);
		userRepository.save(user);
	}

	@GetMapping("users/searchDesignation/{designation}")//search by designation
	public List<User> findByDesignation(@PathVariable("designation")String designation) {
		List<User> userListByDesignation  ;
		userListByDesignation = userRepository.findByDesignation(designation);
		return userListByDesignation;
	}

	@GetMapping("users/searchId/{emp_id}")// search by id 
	public User findById(@PathVariable("emp_id")Integer emp_id,@RequestBody  User user ) {
		Optional<User>userById=userRepository.findById(emp_id);
		if(userById.isPresent()) {
			return userById.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("users/searchName/{name}") //search by name
	public User findByName(@PathVariable("name")String name,@RequestBody User user) { 
		Optional<User>userByName=userRepository.findByName(name);
		if(userByName.isPresent()) {
			return userByName.get();
		}
		else {
			return null;
		}
	}
	
	
	
}
