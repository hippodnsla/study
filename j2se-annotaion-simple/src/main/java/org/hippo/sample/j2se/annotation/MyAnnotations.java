package org.hippo.sample.j2se.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
	MyAnnotation[] value();
}
