package org.hippo.sample.j2ee.log4j;

import org.apache.log4j.Logger;

public class MyClass {
	
	private static final Logger LOGGER = Logger.getLogger(MyClass.class);
	
	public void MyMethod() {
		LOGGER.debug("MyMethod()");
		LOGGER.info("MyMethod()");
		LOGGER.warn("MyMethod()");
		LOGGER.error("MyMethod()");
	}
}
