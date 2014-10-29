package org.hippo.sample.j2se.reflection.invoke;

public class MyClass implements MyInterface {

	/* Class-Load */
	//////////////////////////////////////////////////////////////
	static {
		System.out.println("MyClass loaded ...");
	}
	
	/* Constructor */
	//////////////////////////////////////////////////////////////
	public MyClass() {
		System.out.println("MyClass instanced ...");
	}
	
	public MyClass(float fieldA, String fieldB) throws IllegalArgumentException {
		this();
		this.fieldA = fieldA;
		MyClass.fieldB = fieldB;
	}
	
	/* Methods */
	//////////////////////////////////////////////////////////////
	private void functionA(String param) throws IllegalArgumentException, IllegalStateException {
		System.out.println("functionA been called ...");
	}
	
	public int functionB() {
		System.out.println("functionB been called ...");
	return 0;
	}
	
	protected static <E> E functionC(E param) {
		System.out.println("functionC been called ...");
		return param;
	}
	
	/* Get & Set Methods */
	//////////////////////////////////////////////////////////////
	public float getFieldA() {
		return fieldA;
	}

	public void setFieldA(Float fieldA) {
		this.fieldA = fieldA;
	}

	public static String getFieldB() {
		return fieldB;
	}

	public static void setFieldB(String fieldB) {
		MyClass.fieldB = fieldB;
	}
	
	/* Fields */
	//////////////////////////////////////////////////////////////
	private float fieldA;
	public static String fieldB;

}
