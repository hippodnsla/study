package org.hippo.sample.spring.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	
	private static Logger LOGGER = Logger.getLogger(LogInterceptor.class);
	
	@Pointcut("execution(public * org.hippo.sample.spring.dao..*.*(..))")
	public void myMethod() {}
	
	@Before("myMethod()")
	public void before() {
		LOGGER.debug("execute before function()");
	}
	
	@After("myMethod()")
	public void after() {
		LOGGER.debug("execute after function()");
	}
	
	@AfterReturning("myMethod()")
	public void afterReturning() {
		LOGGER.debug("execute after returing function()");
	}
	
	@AfterThrowing("myMethod()")
	public void afterThrowing() {
		LOGGER.debug("execute after throwing function()");
	}
	
//	@Around("myMethod()")
//	public void around(ProceedingJoinPoint pjp) throws Throwable {
//		LOGGER.debug("execute around (before) function()");
//		pjp.proceed();
//		LOGGER.debug("execute around (after) function()");
//	}
	
}
