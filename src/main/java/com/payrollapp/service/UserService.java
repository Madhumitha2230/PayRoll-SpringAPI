package com.payrollapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payrollapp.model.User;
import com.payrollapp.repository.UserRepository;
import com.payrollapp.validate.UserValidation;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void save(User user) throws Exception {
		try {
			UserValidation.validate(user);
			userRepository.save(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	public User login(User user) throws Exception {
		try {
			UserValidation.validateLogin(user);
			Optional<User> userLogin = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (userLogin.isPresent()) {
				return userLogin.get();
			} else {
				throw new Exception("Invalid login credential");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
