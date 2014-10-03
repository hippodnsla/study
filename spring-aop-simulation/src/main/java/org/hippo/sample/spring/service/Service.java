package org.hippo.sample.spring.service;

import org.hippo.sample.spring.entity.Entity;
import org.springframework.stereotype.Component;

@Component
public interface Service {
	
	Entity getEntity();
	
}
