package com.myretail.product.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CurrencyCode {

	USD("USD"),
	AUD("AUD"),
	GBP("GBP"),
	EUR("EUR"),
	INR("INR");
	
	private String currencyCode;
	
	private CurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@JsonValue
	public String getCurrencyCode() {
		return this.currencyCode;
	}
}
