package com.myretail.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.User;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
	}


	public User save(User user) throws MyRetailException {
		userRepository.save(user);
		return userRepository.findByUsername(user.getUsername());
	}
	
}
