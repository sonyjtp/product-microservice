package com.myretail.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.domain.Pricing;

@Repository
public interface PricingRepository extends MongoRepository<Pricing, Long>
{

	

}
