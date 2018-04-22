package com.myretail.product.controller;

import static com.myretail.product.constants.MyRetailConstants.REQ_MAPPING_ROLES;
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

import com.myretail.product.domain.Role;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.service.RoleService;
import com.myretail.product.vo.MyRetailResponse;
import com.myretail.product.vo.ProductResponse;

@RequestMapping(REQ_MAPPING_ROLES)
@Produces({ APPLICATION_JSON })
@RestController
public class RoleController {

private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}



	@Consumes({APPLICATION_JSON})
	@PostMapping
	public ResponseEntity<MyRetailResponse> create(@RequestBody Role role) throws MyRetailException {
		roleService.save(role);
		return new ResponseEntity<>(new ProductResponse(String.format("Successfully created new role: %s", role.toString())), CREATED);
	}
}
