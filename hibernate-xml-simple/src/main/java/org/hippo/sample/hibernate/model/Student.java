package org.hippo.sample.hibernate.model;

import java.util.Date;

public class Student {
	
	public Student() {}
	public Student(long id, String name, int age, String password, Date birthday) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		this.birthday = birthday;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	private long id;
	private String name;
	private int age;
	private String password;
	private Date birthday;
}
