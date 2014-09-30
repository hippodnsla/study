package org.hippo.sample.spring;

import static org.junit.Assert.*;

import org.hippo.sample.spring.service.UserDataService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDataServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
		
		UserDataService service = (UserDataService)context.getBean("userService");
		
		assertNotNull(service);
		
		
	}

}
