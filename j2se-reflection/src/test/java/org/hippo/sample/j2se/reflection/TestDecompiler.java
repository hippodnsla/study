package org.hippo.sample.j2se.reflection;

import org.hippo.sample.j2se.reflection.decompiler.ClassDecompiler;
import org.hippo.sample.j2se.reflection.decompiler.MyClass;
import org.hippo.sample.j2se.reflection.decompiler.MyExtenedClass;
import org.hippo.sample.j2se.reflection.decompiler.MyInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDecompiler {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyExtenedClass() {
		String clazzString = 
				ClassDecompiler.toClassString(
						MyExtenedClass.class);
		System.out.println(clazzString);
	}
	
	@Test
	public void testMyClass() {
		String clazzString = 
				ClassDecompiler.toClassString(
						MyClass.class);
		System.out.println(clazzString);
	}

	@Test
	public void testMyInterface() {
		String clazzString = 
				ClassDecompiler.toClassString(
						MyInterface.class);
		System.out.println(clazzString);
	}
}
