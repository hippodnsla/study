package org.hippo.sample.j2se.reflection;

import org.hippo.sample.j2se.reflection.invoke.Invoker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInvoker {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		try {
			Class<?> clazz = Class.forName("org.hippo.sample.j2se.reflection.invoke.MyClass");
			Object obj = clazz.newInstance();
			
			System.out.println(Invoker.get(obj, "fieldA"));
			Invoker.set(obj, "fieldA", (float) 1.0);
			System.out.println(Invoker.get(obj, "fieldA"));
			
			System.out.println(Invoker.get(obj, "fieldB"));
			Invoker.setProperty(obj, "fieldB", "hello");
			System.out.println(Invoker.get(obj, "fieldB"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
