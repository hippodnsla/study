package org.hippo.sample.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.dao.UserDao;
import org.hippo.sample.spring.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	@PostConstruct
	public void init() {
		LOGGER.debug("UserService.init()");
		LOGGER.info("UserService initlizaing...");
	}
	
	@PreDestroy
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
