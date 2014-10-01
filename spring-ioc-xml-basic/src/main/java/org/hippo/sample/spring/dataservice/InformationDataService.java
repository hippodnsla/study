package org.hippo.sample.spring.dataservice;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.dao.InformationDao;
import org.hippo.sample.spring.model.InformationEntity;

public class InformationDataService implements DataService<InformationEntity> {

	private static final Logger LOGGER = Logger.getLogger(InformationDataService.class);
	
	public InformationDataService() {
		super();
	}
	
	public void init() {
		LOGGER.debug("InformationDataService - init()");
		LOGGER.info("open resources...");
	}
	
	public void destroy() {
		LOGGER.debug("InformationDataService - destroy()");
		LOGGER.info("free resources...");
	}
	
	public InformationEntity read(long id) {
		LOGGER.debug("InformationDataService - read()");
		return dao.get(id);
	}

	public void write(InformationEntity entity) {
		LOGGER.debug("InformationDataService - write()");
		dao.save(entity);
	}
	
	public Class<InformationEntity> getEntityClass() {
		return InformationEntity.class;
	}
	
	public InformationDao getDao() {
		return dao;
	}

	public void setDao(InformationDao dao) {
		this.dao = dao;
	}
	
	private InformationDao dao;

	
}
