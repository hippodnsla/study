package org.hippo.sample.j2se.reflection;

import static org.junit.Assert.*;

import org.hippo.sample.j2se.reflection.classloader.A;
import org.hippo.sample.j2se.reflection.classloader.B;
import org.hippo.sample.j2se.reflection.classloader.C;
import org.hippo.sample.j2se.reflection.classloader.D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDynamicLoading {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		System.out.println("-----------------------------------------------");
		new A();
		System.out.println("-----------------------------------------------");
		new B();
		System.out.println("-----------------------------------------------");
		new C(); new C();
		System.out.println("-----------------------------------------------");
		new D(); new D();
	}

}
