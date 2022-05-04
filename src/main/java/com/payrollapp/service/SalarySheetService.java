package com.payrollapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollapp.model.SalarySheet;
import com.payrollapp.repository.SalarySheetRepository;
import com.payrollapp.validate.SalarySheetValidation;
@Service
public class SalarySheetService {
	
	@Autowired
	SalarySheetRepository salarysheetRepository;
	public static void save(SalarySheet salarySheet) throws Exception {
		try {
			SalarySheetValidation.validate(salarySheet);
			SalarySheetService.save(salarySheet);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
			
		}
		
	}

}
