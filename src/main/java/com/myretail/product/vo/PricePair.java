package com.myretail.product.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({"value", "currency_code"})
public class PricePair {

	@JsonProperty(value = "currency_code", required = true)
	private CurrencyCode currencyCode;
	
	@JsonProperty(value = "value", required = true)
	private Double value;
	
	
	public PricePair(CurrencyCode currencyCode, Double value) {
		this.currencyCode=currencyCode;
		this.value = value;
	}


}
