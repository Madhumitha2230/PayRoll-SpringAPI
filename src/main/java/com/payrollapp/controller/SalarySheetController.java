package com.payrollapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapp.model.SalarySheet;
import com.payrollapp.repository.SalarySheetRepository;

@RestController
public class SalarySheetController {
	
	@Autowired
	SalarySheetRepository salarySheetRepository;
	
	@PostMapping("salary/save")
	public SalarySheet save(@RequestBody SalarySheet salarySheet) {
		salarySheetRepository.save(salarySheet);
		return salarySheet;
	}
	
	@GetMapping("salary/list")// list all employees"
			public List<SalarySheet>findAll(){
			List<SalarySheet>salaryList=salarySheetRepository.findAll();
			return salaryList;
	}
	
	@PutMapping("salary/update/{emp_id}")//update
	public void update(@PathVariable("emp_id")Integer empId,@RequestBody SalarySheet salarySheet){
		salarySheet.setEmpId(empId);
		salarySheetRepository.save(salarySheet);
	}
	
	@GetMapping("salary/findbyId/{emp_id}")
	public SalarySheet findById(@PathVariable("emp_id")Integer emp_id,@RequestBody SalarySheet salarySheet) {
		Optional<SalarySheet>salarySheetById=salarySheetRepository.findById(emp_id);
		if(salarySheetById.isPresent()) {
			return salarySheetById.get();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("salary/status/{status}")//search by status
		public List<SalarySheet>findByStatus(@PathVariable("status")String status){
			List<SalarySheet>salarySheetByStatus=salarySheetRepository.findByStatus(status);
			return salarySheetByStatus;
		
	}
	
	@GetMapping ("salary/month/{month}")//search by month
	public List<SalarySheet>findByMonth(@PathVariable("month")Integer month){
		List<SalarySheet>salarySheetByMonth=salarySheetRepository.findByMonth(month);
		return salarySheetByMonth;
	}

}
