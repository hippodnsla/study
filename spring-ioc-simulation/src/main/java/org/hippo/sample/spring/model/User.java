package org.hippo.sample.spring.model;

public class User {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + ", " + name; 
	}
	
	private String name;
	private long id;
}
