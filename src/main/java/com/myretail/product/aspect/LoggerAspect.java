package com.myretail.product.aspect;

import java.text.MessageFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Aspect for addressing the logging cross-cutting concern
 * 
 * @author Sony Thomas
 *
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

	/**
	 * Dummy method for defining Around advice 
	 */
	@Pointcut("within(com.myretail..*)")
	private void loggingJoinPoint() {
	}

	/**
	 * Advice to log method entry, method exit and execution time of each method
	 * @param joinPoint
	 * @return return value of the executed method
	 * @throws Throwable
	 */
	@Around("loggingJoinPoint()")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = 0l;
		if (log.isDebugEnabled()) {
			start = System.currentTimeMillis();
			log.info(MessageFormat.format("{0} -->", joinPoint.getSignature().toShortString()));
		}
		Object retVal = joinPoint.proceed();
		if (log.isDebugEnabled()) {
			log.info(MessageFormat.format("Return value: {0}", retVal.toString()));
			long executionTime = System.currentTimeMillis() - start;
			log.info(MessageFormat.format("{0}  executed in {1} ms", joinPoint.getSignature(), executionTime));
			log.info(MessageFormat.format("{0} <--", joinPoint.getSignature().toShortString()));
		}
		return retVal;
	}

}
