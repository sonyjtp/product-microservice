package com.myretail.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myretail.product.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	

}
