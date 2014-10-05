package org.hippo.sample.spring;

import static org.junit.Assert.assertNotNull;

import org.hippo.sample.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/ApplicationContext.xml");
		
		UserService userService = (UserService) context.getBean("userService");
		
		assertNotNull(userService);
		
		userService.addUser(1, "hippo");
		
		try {
			userService.getUser(0);
		} catch (UnsupportedOperationException e) {
			// Do Nothing for test
		}
	}

}
