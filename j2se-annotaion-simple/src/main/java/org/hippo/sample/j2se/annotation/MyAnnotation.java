package org.hippo.sample.j2se.annotation;

public @interface MyAnnotation {
	String name() default "";
	LevelE level();
}
