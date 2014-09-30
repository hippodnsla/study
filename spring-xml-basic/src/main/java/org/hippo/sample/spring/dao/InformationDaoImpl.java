package org.hippo.sample.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.dataservice.DataServiceLocator;
import org.hippo.sample.spring.model.InformationEntity;
import org.hippo.sample.spring.model.InformationEntityImpl;

public class InformationDaoImpl implements InformationDao {

	private static final Logger LOGGER = Logger.getLogger(InformationDaoImpl.class);
	
	public InformationEntity get(long id) {
		LOGGER.debug("InformationDaoImpl - get()");
		return new InformationEntityImpl();
	}

	public List<InformationEntity> getAll() {
		LOGGER.debug("InformationDaoImpl - getAll()");
		return new ArrayList<InformationEntity>();
	}

	public void save(InformationEntity entity) {
	}

	public void save(long id, InformationEntity entity) {
	}

	public void update(InformationEntity entity) {
	}

	public void update(long id, InformationEntity entity) {
	}

	public void delete(InformationEntity entity) {
	}

	public void delete(long id) {
	}

	public int size() {
		return 0;
	}

}
