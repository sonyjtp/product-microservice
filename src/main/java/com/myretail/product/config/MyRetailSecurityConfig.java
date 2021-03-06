package com.myretail.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.myretail.product.constants.MyRetailConstants.ROLE_ADMIN;
import static com.myretail.product.constants.MyRetailConstants.ROLE_USER;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class MyRetailSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService myRetailUserDetailsService;

	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myRetailUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().disable().authorizeRequests(
				).antMatchers("/products").hasRole(ROLE_USER)
				.antMatchers("/products/*").hasRole(ROLE_USER)
				.antMatchers("/users").hasRole(ROLE_ADMIN)
				.antMatchers("/users/*").hasRole(ROLE_ADMIN)
				.anyRequest().authenticated();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
