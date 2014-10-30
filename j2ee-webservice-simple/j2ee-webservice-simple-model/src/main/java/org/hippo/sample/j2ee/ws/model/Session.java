package org.hippo.sample.j2ee.ws.model;

public class Session {

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	private long id;
	private User user;
}
