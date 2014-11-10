package org.hippo.sample.j2se.clazzes;

import org.hippo.sample.j2se.annotation.MyClass;
import org.hippo.sample.j2se.annotation.MyMethod;
import org.hippo.sample.j2se.annotation.MyVariable;
import org.hippo.sample.j2se.annotation.TypeE;

@MyClass("AnnotatedClass")
public abstract class AnnotatedClass implements AnnotatedInterface {
	
	@MyMethod("method")
	public Object method(
			@MyVariable(name="a", type=TypeE.INTEGER) int a,
			@MyVariable(name="b", type=TypeE.STRING) String b) {
		
		@MyVariable(name="c", type=TypeE.OBJECT)
		Object c = null;
		
		return c;
	}
	
	public abstract void function();
	
	@MyVariable(name="field", type=TypeE.FOLAT)
	private float field;
}
