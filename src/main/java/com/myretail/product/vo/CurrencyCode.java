package com.myretail.product.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CurrencyCode {

	USD("US Dollar"),
	AUD("Australian Dollar"),
	GBP("Pound Sterling"),
	EUR("Euro"),
	INR("Indian Rupee");
	
	private String currencyCode;
	
	private CurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@JsonValue
	public String getCurrencyCode() {
		return this.currencyCode;
	}
}
