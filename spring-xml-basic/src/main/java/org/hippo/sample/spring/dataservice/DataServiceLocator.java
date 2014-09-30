package org.hippo.sample.spring.dataservice;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.model.Entity;

public class DataServiceLocator {
	
	private static final Logger LOGGER = Logger.getLogger(DataServiceLocator.class);
	
	public <E extends Entity> DataService<E> findDataService(Class<E> entityClazz) {
		LOGGER.debug("DataServiceLocator - findDataService()");
		for (DataService<?> ds: dataServices) {
			if (ds.getEntityClass().equals(entityClazz))
				return (DataService<E>) ds;
		}
		return null;
	}
	
	public <E extends Entity> void registerDataService(DataService<E> dataService) {
		LOGGER.debug("DataServiceLocator - registerDataService()");
		if (dataServices.contains(dataService)) {
			LOGGER.warn("DataService for "+dataService.getEntityClass()+" already exist");
			return;
		}
		dataServices.add(dataService);
	}
	
	public Set<DataService<?>> getDataServices() {
		return dataServices;
	}

	public void setDataServices(Set<DataService<?>> dataServices) {
		this.dataServices = dataServices;
	}
	
	private Set<DataService<?>> dataServices;
}
