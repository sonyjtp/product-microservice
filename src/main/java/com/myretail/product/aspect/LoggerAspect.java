package com.myretail.product.aspect;

import java.text.MessageFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * Aspect for addressing the logging cross-cutting concern when the active profile is
 * dev. 
 * @author Sony Thomas
 *
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

	@Pointcut("within(com.myretail..*)")
	private void loggingJoinPoint() {}
	
	@Around("loggingJoinPoint()")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//		if(log.isDebugEnabled()){
		long start = System.currentTimeMillis();
			log.info(MessageFormat.format("Entering method: {0}", joinPoint.getSignature().toShortString()));
//	}
			Object retVal = joinPoint.proceed();
//		if(log.isDebugEnabled()) {
			
			log.info(MessageFormat.format("Return value: {0}", retVal.toString()));
			long executionTime = System.currentTimeMillis() - start;
			log.info(joinPoint.getSignature() + " executed in " + executionTime/1000 + " s");
			log.info(MessageFormat.format("Exiting method: {0}", joinPoint.getSignature().toShortString()));
			
//		}
		return retVal;
	}
	
}
