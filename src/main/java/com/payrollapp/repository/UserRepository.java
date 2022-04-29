package com.payrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payrollapp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	


	List<User> findByDesignation(String designation);


}
