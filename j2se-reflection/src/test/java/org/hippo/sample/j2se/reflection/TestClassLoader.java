package org.hippo.sample.j2se.reflection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestClassLoader {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		// Different class loader
		// 	Bootstrap
		System.out.println(String.class.getClassLoader());
		// 	Extension
		//System.out.println(DESKeyFactory.class.getClassLoader());
		// 	Application
		System.out.println(TestClassLoader.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		
		System.out.println();
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		while( loader != null ) {
			System.out.println(loader.getClass().getName());
			loader=loader.getParent();
		}
	}
}
