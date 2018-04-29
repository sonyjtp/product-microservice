package com.myretail.product.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.myretail.product.constants.MyRetailConstants;

@FeignClient(name="${redsky.product.info.service.name}", url="${redsky.product.info.url}")
public interface ProductFeignClient {
	
	@GetMapping("/{id}")
	public String get(@PathVariable(MyRetailConstants.PARAM_ID) String id, @RequestParam(MyRetailConstants.PRODUCT_INFO_EXCLUDES) String excludes);
}

	


