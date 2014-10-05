package org.hippo.sample.spring.log;

import org.apache.log4j.Logger;

public class LogInterceptor {
	
	private static Logger LOGGER = Logger.getLogger(LogInterceptor.class);
	
	public void before() {
		LOGGER.debug("execute before function()");
	}
	
	public void after() {
		LOGGER.debug("execute after function()");
	}
	
	public void afterReturning() {
		LOGGER.debug("execute after returing function()");
	}
	
	public void afterThrowing() {
		LOGGER.debug("execute after throwing function()");
	}
	
//	public void around(ProceedingJoinPoint pjp) throws Throwable {
//		LOGGER.debug("execute around (before) function()");
//		pjp.proceed();
//		LOGGER.debug("execute around (after) function()");
//	}
	
}
