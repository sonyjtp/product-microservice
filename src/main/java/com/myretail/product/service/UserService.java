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
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public User save(User user) throws MyRetailException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return userRepository.findById(user.getUsername()).get();
	}
	
}
