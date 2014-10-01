package org.hippo.sample.spring.dao.impl;

import org.hippo.sample.spring.dao.UserDao;
import org.hippo.sample.spring.model.User;

public class UserDaoImpl implements UserDao {

	public void add(User user) {
		System.out.println("User added ["+user+"]");
	}

	public void remove(User user) {
		System.out.println("User removed ["+user+"]");
	}

	public User find(long id) {
		return new User();
	}

}
