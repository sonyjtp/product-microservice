package com.myretail.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.product.builder.ProductBuilder;
import com.myretail.product.domain.Pricing;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.vo.Product;

@Service
public class ProductService implements MyRetailService<Product, Long> {
	
	private MyRetailService<Pricing, Long> pricingService;
	
	@Autowired
	public ProductService(MyRetailService<Pricing, Long> pricingService) {
		this.pricingService = pricingService;
		
	}

	@Override
	public List<Product> findAll() throws MyRetailException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product find(Long id) throws MyRetailException {
		Pricing pricing =pricingService.find(id);
		return new ProductBuilder(id).setName("").setCurrentPrice(pricing.getCurrentPrice()).build();
	}

	@Override
	public void create(Product t) throws MyRetailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product save(Product t) throws MyRetailException {
		pricingService.save(new Pricing(t.getId(), t.getCurrentPrice()));
		return find(t.getId());
	}

	@Override
	public void delete(Product t) throws MyRetailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long id) throws MyRetailException {
		// TODO Auto-generated method stub
		return false;
	}

}
