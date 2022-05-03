package com.payrollapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="employee_role")
public class Salary {
	

	@Id
	@Column(name="salary",nullable=false)
	public Integer salary;
	
	@Column(name="salary_id",nullable=false)
	public int salaryId;
	
	@Column(name="designation",nullable=false)
	public String designation;
	

}
