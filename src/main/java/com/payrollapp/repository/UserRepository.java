package com.payrollapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payrollapp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	


	List<User> findByDesignation(String designation);

	Optional<User> findByName(String name);
	Optional<User> findByEmailAndPassword(String email, String password);


}
