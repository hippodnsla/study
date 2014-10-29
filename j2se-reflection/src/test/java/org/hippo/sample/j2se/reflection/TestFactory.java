package org.hippo.sample.j2se.reflection;

import org.hippo.sample.j2se.reflection.factory.Factory;
import org.hippo.sample.j2se.reflection.factory.Fruit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFactory {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Fruit apple = Factory.getInstance("apple");
		Fruit orange = Factory.getInstance("orange");
		
		if(apple != null)
			apple.eat();
		if(orange != null)
			orange.eat();
	}

}
