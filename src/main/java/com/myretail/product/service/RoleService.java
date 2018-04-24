package com.myretail.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.Role;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.repository.RoleRepository;

@Service
public class RoleService {

	
private RoleRepository roleRepository;
	
	@Autowired
	public RoleService(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}


	public Role save(Role role) throws MyRetailException {
		roleRepository.save(role);
		return roleRepository.findByRoleName(role.getRoleName());
	}
}
