package org.hippo.sample.spring.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInterceptor {
	
	private static Logger LOGGER = Logger.getLogger(LogInterceptor.class);
	
	@Before("execution(public * org.hippo.sample.spring.dao..*.*(..))")
	public void before() {
		LOGGER.debug("execute before function()");
	}
	
	@After("execution(public * org.hippo.sample.spring.dao..*.*(..))")
	public void after() {
		LOGGER.debug("execute after function()");
	}
	
	@AfterReturning("execution(public * org.hippo.sample.spring.dao..*.*(..))")
	public void afterReturning() {
		LOGGER.debug("execute after returing function()");
	}
	
	@AfterThrowing("execution(public * org.hippo.sample.spring.dao..*.)")
//	@Around("execution(public * org.hippo.sample.spring.dao..*.*(..))")
//	public void around() {
//		LOGGER.debug("execute around function()");
//	}
	
}
