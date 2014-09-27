package org.hippo.sample.spring.dao;


import org.hippo.sample.spring.model.User;

public interface UserDao {
	
	void add(User user);
	
	void remove(User user);
	
	User find(long id);
}
