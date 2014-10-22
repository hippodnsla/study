package org.hippo.sample.j2se.service;

import org.apache.log4j.Logger;
import org.hippo.sample.j2se.entity.Entity;

public class ServiceImpl implements Service {

	private static Logger LOGGER = Logger.getLogger(ServiceImpl.class);
	
	public Entity getEntity() {
		LOGGER.info("Executing ServiceImpl getEntity method ...");
		return null;
	}
	
}
