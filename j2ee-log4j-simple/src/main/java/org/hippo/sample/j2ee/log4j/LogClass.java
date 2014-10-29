package org.hippo.sample.j2ee.log4j;

import org.apache.log4j.Logger;

public class LogClass {
	
	private static final Logger LOGGER = Logger.getLogger(LogClass.class);
	
	public void function() {
		LOGGER.debug("debug");
		LOGGER.info("info");
		LOGGER.warn("warn");
		LOGGER.error("error");
	}
}
