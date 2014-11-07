package org.hippo.sample.j2ee.jaxb;

import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDriver {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMarshall() {
		
		Teacher teacher = mockupTeacher();
		Student student = mockupStudent(teacher);
		
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(student, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUnMarshall() {
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Student student = (Student) unmarshaller.unmarshal(new File("src/main/resources/student.xml"));
			System.out.println(student);
		} catch (JAXBException e) {
			e.printStackTrace();
			fail();
		} catch (ClassCastException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	private Student mockupStudent(Teacher teacher) {
		Student student = new Student();
		// attributes
		student.setId(1);
		student.setName("hippo");
		student.setGrade(Grade.GRADE_TWO);
		// elements
		student.setTeachers(new Teachers());
		student.getTeachers().getTeachers().add(teacher);
		student.getRemarks().add("this student is very bad student");
		student.getRemarks().add("only know eatting everyday");
		return student;
	}
	
	private Teacher mockupTeacher() {
		Teacher teacher = new Teacher();
		teacher.setId(2);
		teacher.setName("lolita");
		return teacher;
	}

}
