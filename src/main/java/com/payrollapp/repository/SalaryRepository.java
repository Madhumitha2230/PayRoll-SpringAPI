package com.payrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payrollapp.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {

	List<Salary> findByDesignation(String designation);

}
