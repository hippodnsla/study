package org.hippo.sample.spring.dao;

import java.util.List;

import org.hippo.sample.spring.model.Entity;

public interface Dao <E extends Entity> {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	E get(long id);
	
	/**
	 * 
	 * @return
	 */
	List<E> getAll();
	
	/**
	 * 
	 * @param entity
	 */
	void save(E entity);
	
	/**
	 * 
	 * @param id
	 * @param entity
	 */
	void save(long id, E entity);
	
	/**
	 * 
	 * @param entity
	 */
	void update(E entity);
	
	/**
	 * 
	 * @param id
	 * @param entity
	 */
	void update(long id, E entity);
	
	/**
	 * 
	 * @param entity
	 */
	void delete(E entity);
	
	/**
	 * 
	 * @param id
	 */
	void delete(long id);
	
	/**
	 * 
	 * @return
	 */
	int size();
	
}
