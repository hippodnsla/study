package org.hippo.sample.j2se.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hippo.sample.j2se.clazzes.AnnotatedExtenedClass;
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
		printClass(AnnotatedExtenedClass.class);
	}
	
	private void printClass(Class<?> clazz) {
		// Print class name
		for(Annotation annotation: clazz.getAnnotations()) {
			if (annotation.annotationType().equals(MyClass.class)) {
				System.out.println(((MyClass)annotation).value());
			}
		}
		System.out.println("{");
		recusivePrintClassContent(clazz);
		System.out.println("}");
	}
	
	private void recusivePrintClassContent(Class<?> clazz) {
		
		if (clazz.equals(Object.class))
			return;
		
		printMethodsInClass(clazz);
		recusivePrintClassContent(clazz.getSuperclass());
		printFieldsInClass(clazz);
	}
	
	private void printFieldsInClass(Class<?> clazz) {
		for (Field field: clazz.getDeclaredFields()) {
			for(Annotation annotation: field.getAnnotations()) {
				if (annotation.annotationType().equals(MyVariable.class)) {
					MyVariable variable = (MyVariable)annotation;
					System.out.println("\t"+variable.type()+" "+variable.name());
				}
			}
		}
	}
	
	private void printMethodsInClass(Class<?> clazz) {
		for (Method method: clazz.getDeclaredMethods()) {
			for (Annotation annotation: method.getAnnotations()) {
				if (!annotation.annotationType().equals(MyMethod.class))
					continue;
				// Print out method name
				System.out.print("\t"+((MyMethod)annotation).value()+"(");
				// Print out parameter
				for (Annotation[] as: method.getParameterAnnotations()) {
					for (int i=0; i<as.length; i++) {
						MyVariable variable = (MyVariable)as[i];
						System.out.print(variable.type()+" "+variable.name());
						if (i<method.getParameterAnnotations().length-1)
							System.out.print(", ");
					}
					
				}
				System.out.println(")");
			}
		}
	}

}
