package org.hippo.sample.j2se.jni;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyJniTest {

	@Before
	public void setUp() throws Exception {
		this.myJni = new MyJni();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDisplay() {
		myJni.display();
	}

	@Test
	public void testSum() {
		Assert.assertEquals(5.1, myJni.sum(2.0, 3.1));
	}
	
	private MyJni myJni;

}
