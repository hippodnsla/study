package org.hippo.sample.j2se;

import org.hippo.sample.j2se.entity.Entity;
import org.hippo.sample.j2se.entity.EntityImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		Factory factory = Factory.getInstance();
		Entity e = factory.getInstance(EntityImpl.class);
		
		e.setId(1L);
		
		System.out.println(e);
		
	}
}
