package com.myretail.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyRetailSecurityConfig  extends WebSecurityConfigurerAdapter
{

	@Autowired
	private UserDetailsService userDetailsService;

 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests().antMatchers("/**").permitAll();
 	}

 	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
 	
 	@Bean
 	public PasswordEncoder passwordEncoder() {
 	    return new BCryptPasswordEncoder();
 	}
 	
 	@Bean
 	public DaoAuthenticationProvider authProvider() {
 		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
 	    authProvider.setUserDetailsService(userDetailsService);
 	    authProvider.setPasswordEncoder(passwordEncoder());
 	    return authProvider;
 	}

 	// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {
// 		http.authorizeRequests().antMatchers("/**").permitAll();
// 	}
//
// 	@Override
// 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
// 		auth.inMemoryAuthentication().withUser("sony").password("sony").roles("ADMIN", "USER");
// 	}

}
