package com.myretail.product.exception;

public class MyRetailException extends Exception {
	
	private String errorMessage;
	
	private Throwable exception;
	
	public MyRetailException(Throwable e, String errorMessage) {
		this.exception = e;
		this.errorMessage = errorMessage;
	}

}
