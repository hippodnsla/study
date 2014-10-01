package org.hippo.sample.spring.dao;

import org.hippo.sample.spring.entity.Entity;

public interface DAO <E extends Entity> {
	
	E get(long id);
	
	boolean save(E entity);
}
