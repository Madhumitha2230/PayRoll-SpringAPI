package com.payrollapp.validate;

import com.payrollapp.model.SalarySheet;

public class SalarySheetValidation {
	public static void validate(SalarySheet salarySheet) throws Exception {
		if(salarySheet.getEmpId()==null) {
			throw new Exception("Invalid employee ID");
		}
		if(salarySheet.getMonth()>=12||salarySheet.getMonth()<=0) {
			throw new Exception("Invalid month");
		}
		if(salarySheet.getNoOfDays()==null||salarySheet.getNoOfDays()<=0||salarySheet.getNoOfDays()>=32) {
			throw new Exception("Invalid working days");
		}
		if(salarySheet.getLeaveDays()==null||salarySheet.getLeaveDays()<0||salarySheet.getLeaveDays()>=32) {
			throw new Exception("Invalid leave days");
		}
		if(salarySheet.getTotalSalary()==null) {
			throw new Exception("Invalid total Salary");
		}
		if(salarySheet.getSalary()==null) {
			throw new Exception("Invalid salary");
		}
		if(salarySheet.getStatus()==null||salarySheet.getStatus().trim()=="") {
			throw new Exception ("Invalid salary status");
		}
	    if(salarySheet.getSalary()>salarySheet.getTotalSalary()) {
			throw new Exception("Invalid salary");
		}
	}

}
