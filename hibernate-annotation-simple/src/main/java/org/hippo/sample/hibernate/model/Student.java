package org.hippo.sample.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name="TBL_STUDENT")
public class Student {
	
	public Student() {}
	public Student(long id, String name, int age, String password, Date birthday, StudentClassTypeE studentClass) {
		this();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		this.birthday = birthday;
		this.studentClass = studentClass;
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
	public StudentClassTypeE getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(StudentClassTypeE studentClass) {
		this.studentClass = studentClass;
	}
	
	@Id
	@Column(name="SID")
	private long id;
	
	@Column(name="SNAME", length=16)
	private String name;
	
	@Column(name="SAGE")
	private int age;
	
	@Transient
	private String password;
	
	@Column(name="SBIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="SCLASS")
	@Enumerated(EnumType.STRING)
	private StudentClassTypeE studentClass;

	
	
}
