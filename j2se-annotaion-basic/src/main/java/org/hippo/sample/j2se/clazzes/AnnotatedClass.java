package org.hippo.sample.j2se.annotation;

@MyClass("AnnotatedClass")
public class AnnotatedClass {
	
	@MyMethod("AnnotatedMethod")
	public void method(
			@MyVariable(name="a", type=TypeE.INTEGER) int a,
			@MyVariable(name="b", type=TypeE.STRING) String b) {
		
		@MyVariable(name="c", type=TypeE.OBJECT)
		Object c;
	}
	
	@MyVariable(name="field", type=TypeE.FOLAT)
	private float field;
}
