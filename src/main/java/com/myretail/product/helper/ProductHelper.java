package com.myretail.product.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.myretail.product.builder.ProductBuilder;
import com.myretail.product.domain.Pricing;
import com.myretail.product.exception.MyRetailException;
import com.myretail.product.feignclient.ProductFeignClient;
import com.myretail.product.service.MyRetailService;
import com.myretail.product.util.JsonUtils;
import com.myretail.product.vo.Product;

@Component
public class ProductHelper {
	
	@Value("${redsky.product.info..excludes}")
	private String excludes;
	@Value("${redsky.product.info.title}")
	private String productNameKey;

	private ProductFeignClient productFeignClient;
	
	public ProductHelper(ProductFeignClient productFeignClient) {
		this.productFeignClient = productFeignClient;
	}
	
	public Product getProductDetails(MyRetailService<Pricing, Long> pricingService, Long id) 
			throws InvocationTargetException, MyRetailException, InterruptedException, ExecutionException{
		String productName;
		Pricing pricing;
		CompletableFuture<Pricing> pricingFtr = CompletableFuture.completedFuture(pricingService.find(id));
		CompletableFuture<String> productInfoFtr = CompletableFuture.completedFuture(productFeignClient.get(id.toString(), excludes));
		List<CompletableFuture<?>> operations = new ArrayList<>();
		operations.add(pricingFtr);
		operations.add(productInfoFtr);
		CompletableFuture.allOf(operations.toArray(new CompletableFuture[] {})).join();
		pricing = pricingFtr.get();
		productName = JsonUtils.getStringValue(productFeignClient.get(id.toString(), excludes), productNameKey);
		if(productName==null || pricing==null)
			throw new MyRetailException(String.format("Could not retrieve product details for product %s", id.toString()));
		return new ProductBuilder(id).setName(productName).setCurrentPrice(pricing.getCurrentPrice()).build();
	}
	
}
