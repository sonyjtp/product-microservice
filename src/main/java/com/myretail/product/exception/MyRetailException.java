package com.myretail.product.exception;

import lombok.Getter;

@Getter
public class MyRetailException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resource;

	private String errorMessage;
	
	private Throwable exception;
	
	public MyRetailException(Throwable e, String errorMessage) {
		this.exception = e;
		this.errorMessage = errorMessage;
	}

}
