package org.hippo.sample.j2se.jni;

public class MyJni {

	static {
		System.loadLibrary("myjni");
	}
	
	public native void display();
	
	public native double sum(double x, double y);
	
	
}
