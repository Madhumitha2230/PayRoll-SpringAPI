package com.payrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payrollapp.model.SalarySheet;

public interface SalarySheetRepository extends JpaRepository <SalarySheet,Integer>{

	List<SalarySheet> findByStatus(String status);

	List<SalarySheet> findByMonth(Integer month);

}
