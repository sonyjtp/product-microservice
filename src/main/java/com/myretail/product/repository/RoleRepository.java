package com.myretail.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.domain.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {

	Role findByRoleName(String roleName);
	
}
