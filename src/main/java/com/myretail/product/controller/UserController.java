package com.myretail.product.controller;

import static com.myretail.product.constants.MyRetailConstants.REQ_MAPPING_USERS;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.product.domain.User;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.service.UserService;
import com.myretail.product.vo.MyRetailResponse;
import com.myretail.product.vo.ProductResponse;

@RequestMapping(REQ_MAPPING_USERS)
@Produces({ APPLICATION_JSON })
@RestController
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}



	@Consumes({APPLICATION_JSON})
	@PostMapping
	public ResponseEntity<MyRetailResponse> create(@RequestBody User user) throws MyRetailException {
		userService.save(user);
		return new ResponseEntity<>(new ProductResponse(String.format("Successfully created new role: %s", user.toString())), CREATED);
	}
}
