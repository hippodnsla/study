package org.hippo.sample.spring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.hippo.sample.spring.dao.impl.UserDaoImpl;
import org.hippo.sample.spring.di.BeanFactory;
import org.hippo.sample.spring.di.ClassPathXmlApplicationContext;
import org.hippo.sample.spring.service.UserDataService;
import org.jdom.JDOMException;
import org.junit.Before;
import org.junit.Test;

public class ClassPathXmlApplicationContextTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testClassPathXmlApplicationContext() {
		try {
			new ClassPathXmlApplicationContext();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (InstantiationException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail();
		} catch (JDOMException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail();
		} catch (SecurityException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testClassPathXmlApplicationContextByFileName() {
		try {
			String filename = "beans.xml";
			new ClassPathXmlApplicationContext(filename);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (InstantiationException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail();
		} catch (JDOMException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail();
		} catch (SecurityException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void testGetBean() {
		String filename = "beans.xml";
		try {
			BeanFactory factory = new ClassPathXmlApplicationContext(filename);
			
			Object o = factory.getBean("userService");
			assertNotNull(o);
			assertTrue(o instanceof UserDataService);
			UserDataService userService = (UserDataService)o;
			assertNotNull(userService.getDao());
			
			o = factory.getBean("userDao");
			assertNotNull(o);
			assertTrue(o instanceof UserDaoImpl);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (InstantiationException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			fail();
		} catch (JDOMException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			fail();
		} catch (SecurityException e) {
			e.printStackTrace();
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			fail();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail();
		}
	}

}
