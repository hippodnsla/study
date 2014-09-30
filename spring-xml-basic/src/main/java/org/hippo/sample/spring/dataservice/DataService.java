package org.hippo.sample.spring.dataservice;

import org.hippo.sample.spring.model.Entity;


public interface DataService <E extends Entity> {
	
	E read(long id);

	void write(E entity);
	
	Class<E> getEntityClass();
	
}
