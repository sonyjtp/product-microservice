package com.myretail.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements MyRetailResponse {
	
	private Long id;
	
	private String name;
	
	private PricePair currentPrice;
	
	public Product(Long id) {
		this.id = id;
	}
	
}
