package org.hippo.sample.spring;

import org.hippo.sample.spring.entity.Entity;
import org.hippo.sample.spring.entity.EntityImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		Factory factory = Factory.getInstance();
		Entity e = factory.getInstance(EntityImpl.class);
		
		e.setId(1L);
		
		System.out.println(e);
		
	}
}
