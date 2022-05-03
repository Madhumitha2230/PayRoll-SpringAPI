package com.payrollapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapp.model.Salary;
import com.payrollapp.repository.SalaryRepository;



@RestController
public class SalaryController {
	
	@Autowired
	SalaryRepository salaryRepository;
	
	@PostMapping("totalSalary/save")
	public Salary save(@RequestBody Salary salary) {
		salaryRepository.save(salary);
		return salary;
		}
	
	@GetMapping("totalSalary/list") //list all salary details
	public List<Salary>findAll(){
		List<Salary>salaryList=salaryRepository.findAll();
		return salaryList;
	}
	
	@PutMapping("totalSalary/update/{designation}")//update
	public void update(@PathVariable("designation")String designation,@RequestBody Salary salary) {
		salary.setDesignation(designation);
		salaryRepository.save(salary);
	}
	
	@GetMapping("totalSalary/searchDesignation/{designation}")//search by designation
	public List<Salary>findByDesignation(@PathVariable("designation")String designation){
		List<Salary>salaryListByDesignation=salaryRepository.findByDesignation(designation);
		return salaryListByDesignation;
	}
	

}
