package org.hippo.sample.spring.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import org.hippo.sample.spring.dao.UserDao;
import org.hippo.sample.spring.entity.User;


@Service
public class UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	
	public void init() {
		LOGGER.debug("UserService.init()");
		LOGGER.info("UserService initlizaing...");
	}
	
	public void destory() {
		LOGGER.debug("UserService.destory()");
		LOGGER.info("UserService destorying...");
	}
	
	public void addUser(long id, String name) {
		LOGGER.debug("UserService.addUser()");
		User u = new User();
		u.setId(id);
		u.setName(name);
		getDao().save(u);
	}
	
	public User getUser(long id) {
		LOGGER.debug("UserService.getUser()");
		return getDao().get(id);
	}
	
	public UserDao getDao() {
		return dao;
	}

	@Resource(name="userDao")
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	private UserDao dao;
}
