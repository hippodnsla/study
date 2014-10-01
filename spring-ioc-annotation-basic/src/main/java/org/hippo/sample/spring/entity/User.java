package org.hippo.sample.spring.entity;

public class User implements Entity {

	private static final long serialVersionUID = 2414926635911516533L;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private String name;
	private long id;

}
