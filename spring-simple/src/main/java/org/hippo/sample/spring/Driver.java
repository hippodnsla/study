package org.hippo.sample.spring;

import org.hippo.sample.spring.service.UserDataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		
		UserDataService userDataService = (UserDataService) context.getBean("userService");
		
		userDataService.findUserById(0);
		

	}

}
