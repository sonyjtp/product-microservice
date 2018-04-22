package com.myretail.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.product.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	
	
}
