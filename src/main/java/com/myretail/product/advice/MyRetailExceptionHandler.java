package com.myretail.product.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myretail.product.constants.MyRetailConstants;
import com.myretail.product.exception.MyRetailException;

@RestControllerAdvice
public class MyRetailExceptionHandler {
	
	@ExceptionHandler(value=MyRetailException.class)
	public String handleMyRetailException(MyRetailException e){
		return "error";
	}
	
	@ExceptionHandler(value=AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException e){
		return MyRetailConstants.EXCP_ACCESS_DENIED;
	}

}
