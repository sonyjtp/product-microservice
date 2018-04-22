package com.myretail.product.controller;

import static com.myretail.product.constants.MyRetailConstants.REQ_MAPPING_PRODUCTS;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.product.constants.MyRetailConstants;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.service.MyRetailService;
import com.myretail.product.service.ProductService;
import com.myretail.product.vo.MyRetailResponse;
import com.myretail.product.vo.Product;
import com.myretail.product.vo.ProductResponse;

@RequestMapping(REQ_MAPPING_PRODUCTS)
@Produces({ APPLICATION_JSON })
@RestController
public class ProductController {

	private MyRetailService<Product, Long> productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Consumes({APPLICATION_JSON})
	@PostMapping
	public ResponseEntity<MyRetailResponse> create(@RequestBody Product product) throws MyRetailException {
		productService.save(product);
		return new ResponseEntity<>(new ProductResponse("Successfully created new product"), CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MyRetailResponse> get(@PathVariable(MyRetailConstants.PARAM_ID) Long id)
			throws MyRetailException {
		return new ResponseEntity<>(productService.find(id), OK);
	}

	@PutMapping("/{id}")
	@Consumes({ APPLICATION_JSON })
	public ResponseEntity<MyRetailResponse> updatePrice(@RequestBody Product product) throws MyRetailException {
		return new ResponseEntity<>(productService.save(product), OK);
	}

}
