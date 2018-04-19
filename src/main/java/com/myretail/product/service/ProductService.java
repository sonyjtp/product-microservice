package com.myretail.product.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.Product;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	private ProductRepository productRepository;

//	@Autowired
//	public ProductService(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}

	public Product get(Long id) throws MyRetailException {
		Product product = null;
		try {
//			product = productRepository.findById(id).get();
			product = new Product();
		} catch (NoSuchElementException e) {
			String errorMessage = String.format("Invalid product id: %d", id);
			log.error(errorMessage);
			throw new MyRetailException(e, errorMessage);
		}catch(DataAccessException e) {
			String errorMessage = "Unable to access database";
			log.error(errorMessage);
			throw new MyRetailException(e, errorMessage);
		}
		
		return product;
	}
}
