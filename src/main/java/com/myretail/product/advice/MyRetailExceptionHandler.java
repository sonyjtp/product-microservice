package com.myretail.product.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myretail.product.exception.MyRetailException;
import com.myretail.product.vo.ProductResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class MyRetailExceptionHandler {
	
	@ExceptionHandler(value=MyRetailException.class)
	public ResponseEntity<ProductResponse> handleProductException(MyRetailException e){
		return new ResponseEntity<ProductResponse>(createErrorResponse(e), HttpStatus.BAD_REQUEST);
				
	}
	
//	@ExceptionHandler(value=AccessDeniedException.class)
//	public String handleAccessDeniedException(AccessDeniedException e){
//		return MyRetailConstants.EXCP_ACCESS_DENIED;
//	}
	
	
	private ProductResponse createErrorResponse(MyRetailException e) {
		log.error(e.getErrorMessage(), e.getMessage());
		return new ProductResponse(e.getErrorMessage());
	}

}
