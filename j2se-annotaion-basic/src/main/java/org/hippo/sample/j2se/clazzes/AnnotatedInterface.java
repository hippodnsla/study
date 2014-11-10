package org.hippo.sample.j2se.clazzes;

import org.hippo.sample.j2se.annotation.MyMethod;

public interface AnnotatedInterface {
	
	@MyMethod("function")
	public void function();
}
