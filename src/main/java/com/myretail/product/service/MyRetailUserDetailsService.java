package com.myretail.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.User;
import com.myretail.product.repository.UserRepository;
import com.myretail.product.vo.MyRetailUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyRetailUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public MyRetailUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user ==null) {
			log.info("User: null");
			throw new UsernameNotFoundException( username);
		}
		log.info(String.format("User: %s", user.toString()));
		return new MyRetailUserDetails(user);
	}

}
