package com.myretail.product.vo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"id", "name", "current_price"})
public class Product implements MyRetailResponse {
	
	@NotNull
	private Long id;
	
	@NotNull
	private String name;
	
	@JsonProperty(value = "current_price", required = true)
	private PricePair currentPrice;
	
	public Product(Long id) {
		this.id = id;
	}
	
}
