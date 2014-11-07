package org.hippo.sample.j2ee.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD) 
@XmlRootElement(name="student")
public class Student {

	public Student() {
		super();
		this.remarks = new ArrayList<String>();
	}
	
	@Override
	public String toString() {
		String content = "student ["+id;
		content += ", "+name;
		content += ", "+grade;
		content += ", "+teachers;
		content += ", remarks {";
		for (String remark: remarks)
			content += remark + ", ";
		content = content.substring(0, content.length()-2);
		content += "}";
		content += "]";
		return content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Teachers getTeachers() {
		return teachers;
	}
	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
	public List<String> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}
	
	@XmlAttribute(name="id", required=true)
	protected int id;
	@XmlAttribute(name="name")
	protected String name;
	@XmlAttribute(name="grade")
	protected Grade grade;
	@XmlElement(name="teachers")
	protected Teachers teachers;
	@XmlList
	protected List<String> remarks;
}
