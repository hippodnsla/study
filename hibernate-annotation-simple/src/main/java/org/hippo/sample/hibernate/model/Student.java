package org.hippo.sample.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TBL_STUDENT")
public class Student {
	
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
	
	@Id
	@Column(name="SID")
	private long id;
	
	@Column(name="SNAME", length=16)
	private String name;
	
	@Column(name="SAGE")
	private int age;
}
