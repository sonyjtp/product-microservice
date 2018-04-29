package com.myretail.product.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myretail.product.exception.MyRetailException;
import com.myretail.product.vo.ProductResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * RestControllerAdvice for handling all exceptions thrown. This class has methods for creating user-friendly
 * error messages to be set in the response body.
 * 
 * @author Sony Thomas
 *
 */
@Slf4j
@RestControllerAdvice
public class MyRetailExceptionHandler {
	
	public static String msgExceptionGeneric = "Exception occurred :%s";


	@ExceptionHandler(value=MyRetailException.class)
	public ResponseEntity<ProductResponse> handleProductException(MyRetailException e){
		return new ResponseEntity<ProductResponse>(createErrorResponse(e), HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler(value=AccessDeniedException.class)
	public ResponseEntity<ProductResponse> handleAccessDeniedException(Exception e){
		return new ResponseEntity<ProductResponse>(createErrorResponse(e), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value=UsernameNotFoundException.class)
	public ResponseEntity<ProductResponse> handleUsernameNotFound(Exception e){
		return new ResponseEntity<ProductResponse>(createErrorResponse(e), HttpStatus.UNAUTHORIZED);
	}
	
	private <U extends MyRetailException> ProductResponse createErrorResponse(U e) {
		log.error(String.format(msgExceptionGeneric, e.getMessage()));
		return new ProductResponse(e.getErrorMessage());
	}
	
	
	private <T extends Exception> ProductResponse createErrorResponse(T e) {
		log.error(String.format(msgExceptionGeneric, e.getMessage()));
		return new ProductResponse(e.getMessage());
	}

}
