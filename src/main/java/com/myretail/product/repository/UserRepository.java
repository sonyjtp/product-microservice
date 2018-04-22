package com.myretail.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.product.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
