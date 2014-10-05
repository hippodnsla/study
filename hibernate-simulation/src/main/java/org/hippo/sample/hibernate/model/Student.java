package org.hippo.sample.hibernate.model;

import java.io.Serializable;


public class Student implements Serializable {
	
	private static final long serialVersionUID = 1429933371903636264L;

	public Student() {}
	public Student(long id, String name, int age) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public long id;
	
	private String name;
	
	private int age;
}
