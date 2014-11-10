package org.hippo.sample.j2se.reflection.decompiler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassDecompiler {
	
	public static String toClassString(Class<?> clazz) {
		// TODO Generic, Annotation
		// Print annotations
//		for(Annotation a: clazz.getAnnotations()) {
//			Class<? extends Annotation> c = a.getClass();
//			//System.out.println("@"+c.getName());
//			System.out.println(c.getSimpleName());
//			
//		}
		//Class<? extends Annotation>[] annotations = (Class<? extends Annotation>[]) new Class[list.size()];
		String content = "";
		// Print modifiers
		String modifiersString = toModifiersString(clazz.getModifiers());
		content += addSpace(modifiersString);
		// Print class name
		String clazzNameString = clazz.getSimpleName();
		content += addSpace(clazzNameString);
		// Print super class
		String superclassString = toExtendsString(clazz.getSuperclass());
		content += addSpace(superclassString);
		// Print implemented interface
		String implementsString = toImplementsString(clazz.getInterfaces());
		content += addSpace(implementsString);
					
		content += "{\n" + "\n";
		// Print constructors
		content += toConstructorsString(clazz.getDeclaredConstructors()) + "\n";
		// Print methods
		content += toMethodsString(clazz.getDeclaredMethods()) + "\n";
		// Print fields
		content += toFieldsString(clazz.getDeclaredFields()) + "\n";
		content += "}\n";
		return content;
	}
	
	private static String toMethodsString(Method[] methods) {
		// TODO Annotation, Generic
		String content = "";
		for(Method m : methods) {
			content += "\t";
			// Print modifiers
			String modifiersString = toModifiersString(m.getModifiers());
			content += addSpace(modifiersString);
			// Print return type
			content += toTypeString(m.getReturnType()) + " ";
			// Print method name
			content += m.getName();
			// Print parameters
			content += "(" + toParametersString(m.getParameterTypes()) + ")";
			// Print exceptions
			String exceptionsString = toExceptionsString(m.getExceptionTypes());
			content += addSpace(exceptionsString) + exceptionsString + ";\n";
		}
		return content;
	}
	private static String toConstructorsString(Constructor<?>[] constructors) {
		// TODO Annotation, Generic
		String content = "";
		for(Constructor<?> c : constructors) {
			content += "\t";
			// Print modifiers
			String modifiersString = toModifiersString(c.getModifiers());
			content += addSpace(modifiersString);
			// Print method name
			content += c.getName();
			// Print parameters
			content += "(" + toParametersString(c.getParameterTypes()) + ")";
			// Print exceptions
			String exceptionsString = toExceptionsString(c.getExceptionTypes());
			content += addSpace(exceptionsString) + exceptionsString + ";\n";
		}
		return content;
	}
	private static String toFieldsString(Field[] fields) {
		// TODO Annotation, Generic
		String content = "";
		for(Field f : fields) {
			content += "\t";
			// Print modifiers
			content += addSpace(toModifiersString(f.getModifiers()));
			// Print type
			content += addSpace(toTypeString(f.getType()));
			// Print name
			content += f.getName() + ";\n";
		}
		return content;
	}
	//////////////////////////////////////////////////////////
	private static String toExtendsString(Class<?> superclazz) {
		if( superclazz == null )
			return "";
		if( superclazz.equals(Object.class) )
			return "";
		String content = "extends " + superclazz.getName();
		return content;
	}
	private static String toImplementsString(Class<?>[] interfaces) {
		if( interfaces.length <= 0 )
			return "";
		String content = "implements ";
		for(Class<?> i: interfaces)
			content += i.getName() + ", ";
		content = content.substring(0, content.length()-2);
		return content;
	}
	
	private static String toParametersString(Class<?>[] params) {
		// TODO Annotation, Generic
		if( params.length <= 0 )
			return "";
		String content = "";
		for(Class<?> p : params)
			content += toTypeString(p) + ", ";
		content = content.substring(0, content.length()-2);
		return content;
	}
	private static String toExceptionsString(Class<?>[] exceptions) {
		if( exceptions.length <= 0 )
			return "";
		String content = "throws ";
		for(Class<?> e : exceptions)
			content += toTypeString(e) + ", ";
		content = content.substring(0, content.length()-2);
		return content;
	}
	private static String toModifiersString(int modifiers) {
		
		if( modifiers == 0 )
			return "";
		
		String content = "";
		if(Modifier.isAbstract(modifiers))
			content += "abstract" + " ";
		if(Modifier.isFinal(modifiers))
			content += "final" + " ";
		if(Modifier.isInterface(modifiers))
			content += "interface" + " ";
		if(Modifier.isNative(modifiers))
			content += "native" + " ";
		if(Modifier.isPrivate(modifiers))
			content += "private" + " ";
		if(Modifier.isProtected(modifiers))
			content += "protected" + " ";
		if(Modifier.isPublic(modifiers))
			content += "public" + " ";
		if(Modifier.isStatic(modifiers))
			content += "static" + " ";
		if(Modifier.isStrict(modifiers))
			content += "strict" + " ";
		if(Modifier.isSynchronized(modifiers))
			content += "synchronized" + " ";
		if(Modifier.isTransient(modifiers))
			content += "transient" + " ";
		if(Modifier.isVolatile(modifiers))
			content += "volatile" + " ";
		content = content.substring(0, content.length()-1);
		return content;
	}
	//////////////////////////////////////////////////////////
	private static String toTypeString(Class<?> type) {
		// TODO Generic, Object[]
		String content = "";
		
		if(type.isArray()) {
			if(type.getName().equals("[I"))
				content += "int[]";
			if(type.getName().equals("[F"))
				content += "float[]";
			// ...
			// else
			// get type from array
		} else {
			content += type.getName();
		}
		return content;
	}
	private static String addSpace(String content) {
		return content + (content.isEmpty() ? "" : " ");
	}
}
