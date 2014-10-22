package org.hippo.sample.j2se.annotation;

import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.hippo.sample.j2se.annotation.LevelE;
import org.hippo.sample.j2se.annotation.MyAnnotation;
import org.hippo.sample.j2se.annotation.MyAnnotations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDriver {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		
		this.function();
		
		Class<TestDriver> clazz = TestDriver.class;
		Method method = clazz.getMethod("function");
		
		assertTrue(method.isAnnotationPresent(MyAnnotations.class));
		
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation: annotations) {
			System.out.println(annotation.annotationType().getName());
			if (annotation instanceof MyAnnotations) {
				MyAnnotations myAnnotations = (MyAnnotations) annotation;
				for (MyAnnotation a: myAnnotations.value()) {
					System.out.println("["+a.name()+", "+a.level()+"]");
				}
			}
		}
	}
	
	@MyAnnotations({
		@MyAnnotation(level=LevelE.ONE),
		@MyAnnotation(name="two", level=LevelE.TWO)
	})
	public void function() {
		
	}
}
