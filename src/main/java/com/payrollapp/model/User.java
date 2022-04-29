package com.payrollapp.model;

import java.sql.Date;
import java.time.LocalDate;

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

@Entity(name="employees_details")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id", nullable=false)
	private Integer empId;
	@Column (name="name", nullable=false)
	private String name;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="dob",nullable=false)
	private Date dob;
	@Column(name="designation",nullable=false)
	private String designation;
	@Column(name="date_of_joined",nullable=false)
	private LocalDate dateOfJoining;
	@Column(name="date_of_releiving")
	private LocalDate dateOfReleiving;
	

}
