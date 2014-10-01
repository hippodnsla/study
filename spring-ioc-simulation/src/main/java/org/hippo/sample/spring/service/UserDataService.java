package org.hippo.sample.spring.service;

import org.hippo.sample.spring.dao.UserDao;
import org.hippo.sample.spring.model.User;
import org.springframework.util.Assert;

public class UserDataService {

	
	public User findUserById(long id) {
		return getDao().find(id);
	}
	
	public UserDao getDao() {
		if (dao == null)
			throw new IllegalStateException();
		return dao;
	}

	public void setDao(UserDao dao) {
		Assert.notNull(dao);
		this.dao = dao;
	}
	
	private UserDao dao;
}
