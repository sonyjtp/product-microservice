package com.myretail.product.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myretail.product.domain.Pricing;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.helper.ProductHelper;
import com.myretail.product.vo.Product;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService implements MyRetailService<Product, Long> {

	private MyRetailService<Pricing, Long> pricingService;
	
	private ProductHelper productHelper;

	@Autowired
	public ProductService(MyRetailService<Pricing, Long> pricingService, ProductHelper productHelper) {
		this.pricingService = pricingService;
		this.productHelper = productHelper;
	}

	@Override
	public List<Product> findAll() throws MyRetailException {
		List<Pricing> pricings = pricingService.findAll();
		List<Product> products = new ArrayList<>();
		for (Pricing pricing : pricings) {
			products.add(new Product(pricing.getId(), "x", pricing.getCurrentPrice()));
		}
		return products;
	}

	@Override
	public Product find(Long id) throws MyRetailException {
		try 
		{
				return productHelper.getProductDetails(pricingService, id);
		}
		catch(FeignException | InvocationTargetException | InterruptedException | ExecutionException e) {
			log.error(String.format("Exception occurred while trying to retrieve product info: %s",e.getMessage()), e);
			throw new MyRetailException(e, "Unable to retrieve product info");
		}
		
	}

	@Override
	public void create(Product t) throws MyRetailException {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Product t) throws MyRetailException {
		pricingService.save(new Pricing(t.getId(), t.getCurrentPrice()));
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
