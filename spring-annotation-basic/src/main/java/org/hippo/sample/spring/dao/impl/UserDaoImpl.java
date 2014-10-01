package org.hippo.sample.spring.dao.impl;

import org.apache.log4j.Logger;
import org.hippo.sample.spring.dao.UserDao;
import org.hippo.sample.spring.entity.User;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	public User get(long id) {
		LOGGER.debug("UserDaoImpl.get()");
		return null;
	}

	public boolean save(User entity) {
		LOGGER.debug("UserDaoImpl.save()");
		return false;
	}

}
