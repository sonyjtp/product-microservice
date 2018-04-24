package com.myretail.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	User findByUsername(String username);
}
