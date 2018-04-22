package com.myretail.product.vo;

import com.myretail.product.constants.MyRetailConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductResponse implements MyRetailResponse {
	
	private String resource = MyRetailConstants.RESOURCE_PRODUCT;
	
	private String message;
	
	public ProductResponse(String message) {
		this.message = message;
	}

}
