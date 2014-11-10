package org.hippo.sample.j2se.clazzes;

import org.hippo.sample.j2se.annotation.MyMethod;
import org.hippo.sample.j2se.annotation.MyVariable;
import org.hippo.sample.j2se.annotation.TypeE;

public class AnnotatedExtenedClass extends AnnotatedClass implements AnnotatedInterface {

	@MyMethod("function")
	public void function() {
		
	}
	
	@MyVariable(name="variable", type=TypeE.FOLAT)
	private float variable;
}
