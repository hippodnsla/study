package org.hippo.sample.j2ee.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="teachers")
public class Teachers {

	public Teachers() {
		super();
		this.teachers = new ArrayList<Teacher>();
	}
	
	@Override
	public String toString() {
		String content = "{";
		for (int i=0; i<teachers.size(); i++) {
			content += teachers.get(i);
			if (i<teachers.size()-1)
				content += ", ";
		}
			
		content += "}";
		return content;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@XmlElement(name="teacher")
	protected List<Teacher> teachers;

}
