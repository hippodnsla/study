package org.hippo.sample.spring.service;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.entity.Entity;

public class ServiceImpl implements Service {

	private static Logger LOGGER = Logger.getLogger(ServiceImpl.class);
	
	public Entity getEntity() {
		LOGGER.info("Executing ServiceImpl getEntity method ...");
		return null;
	}
	
}
