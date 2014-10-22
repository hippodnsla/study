package org.hippo.sample.j2se.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
		Class<AnnotatedClass> annotatedClassClazz = AnnotatedClass.class;
		
		// Print out class
		for(Annotation annotation: annotatedClassClazz.getAnnotations()) {
			if (annotation.annotationType().equals(MyClass.class)) {
				System.out.println(((MyClass)annotation).value());
			}
		}
		
		System.out.println("{");
		
		// Print out fields
		for (Field field: annotatedClassClazz.getDeclaredFields()) {
			for(Annotation annotation: field.getAnnotations()) {
				if (annotation.annotationType().equals(MyVariable.class)) {
					MyVariable variable = (MyVariable)annotation;
					System.out.println("\t"+variable.type()+" "+variable.name());
				}
			}
		}
		
		// Print out methods
		for (Method method: annotatedClassClazz.getMethods()) {
			for (Annotation annotation: method.getAnnotations()) {
				if (annotation.annotationType().equals(MyMethod.class)) {
					System.out.print("\t"+((MyMethod)annotation).value());
				}
				System.out.print("(");
				// Print out parameter
				for (Annotation[] as: method.getParameterAnnotations()) {
					for (Annotation a: as) {
						MyVariable variable = (MyVariable)a;
						System.out.print(variable.type()+" "+variable.name()+", ");
					}
					
				}
				System.out.println(")");
			}
		}
		
		System.out.println("}");
		
	}

}
