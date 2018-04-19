package com.myretail.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.product.constants.MyRetailConstants;
import com.myretail.product.domain.Product;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.service.ProductService;

@RequestMapping(MyRetailConstants.REQ_MAPPING_PRODUCT)
@RestController
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") Long id) throws MyRetailException {
		return productService.get(id);
	}

}
