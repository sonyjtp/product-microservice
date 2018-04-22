package com.myretail.product.builder;

import com.myretail.product.vo.PricePair;
import com.myretail.product.vo.Product;

public class ProductBuilder {

	private Long id;

	private String name;

	private PricePair currentPrice;
	
	
	public ProductBuilder(Long id) {
		this.id = id;
	}
	
	public ProductBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public ProductBuilder setCurrentPrice(PricePair currentPrice) {
		this.currentPrice = currentPrice;
		return this;
	}
	
	public Product build() {
		return new Product(this.id, this.name, this.currentPrice);
	}

}
