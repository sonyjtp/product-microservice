package com.myretail.product.vo;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PricePair {

	private CurrencyCode currencyCode;
	
	private Double value;
	
	
	public PricePair(CurrencyCode currencyCode, Double value) {
		this.currencyCode=currencyCode;
		this.value = value;
	}


}
