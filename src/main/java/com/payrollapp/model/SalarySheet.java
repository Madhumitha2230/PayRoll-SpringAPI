package com.payrollapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Entity(name="employee_salary_payroll")
public class SalarySheet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="emp_id")
	private Integer empId;
	@Column(name="month", nullable=false)
	private int month;
	@Column(name="year")
	private int year;
	@Column(name="no_of_days",nullable=false)
	private int noOfDays;
	@Column(name="leave_days")
	private int leaveDays;
	@Column(name="salary",nullable=false)
	private int salary;
	@Column(name="status",nullable=false)
	private String status;
	
	
	
	

}
