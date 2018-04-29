package com.myretail.product.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myretail.product.builder.ProductBuilder;
import com.myretail.product.domain.Pricing;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.feignclient.ProductFeignClient;
import com.myretail.product.util.JsonUtils;
import com.myretail.product.vo.Product;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService implements MyRetailService<Product, Long> {

	private MyRetailService<Pricing, Long> pricingService;

	private ProductFeignClient productFeignClient;

	@Value("${redsky.product.info..excludes}")
	private String excludes;
	@Value("${redsky.product.info.title}")
	private String productNameKey;
	

	@Autowired
	public ProductService(MyRetailService<Pricing, Long> pricingService, ProductFeignClient productFeignClient) {
		this.pricingService = pricingService;
		this.productFeignClient = productFeignClient;
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
		String productName = null;
		Pricing pricing = null;
		try {
			String productInfo = productFeignClient.get(id.toString(), excludes);
			productName = JsonUtils.getStringValue(productInfo, productNameKey);
			if(productName==null)
				throw new MyRetailException("Could not retrieve name of the product");
			 pricing =pricingService.find(id);
		}
		catch(FeignException | InvocationTargetException e) {
			log.error(String.format("Exception occurred while trying to retrieve product info: %s",e.getMessage()), e);
			throw new MyRetailException(e, "Unable to retrieve product info");
		}
		return new ProductBuilder(id).setName(productName).setCurrentPrice(pricing.getCurrentPrice()).build();
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
