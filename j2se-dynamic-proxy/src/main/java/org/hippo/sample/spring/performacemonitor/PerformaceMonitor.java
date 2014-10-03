package org.hippo.sample.spring.performacemonitor;

import org.apache.log4j.Logger;

public class PerformaceMonitor {
	
	private static Logger LOGGER = Logger.getLogger(PerformaceMonitor.class);
	
	public void begin() {
		LOGGER.info("Executing PerformaceMonitor begin method ...");
	}
	
	public void end() {
		LOGGER.info("Executing PerformaceMonitor end method ...");
	}
}
