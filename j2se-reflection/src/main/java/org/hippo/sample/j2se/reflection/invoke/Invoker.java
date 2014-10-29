package org.hippo.sample.j2se.reflection.invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoker {
	
	public static <O> Object get(O obj, String att) {
		try {
			Method m = obj.getClass().getMethod("get"+nomalizeAttr(att));
			return m.invoke(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <O, V> void set(O obj, String att, V value) {
		try {
			Method m = obj.getClass().getMethod("set"+nomalizeAttr(att), value.getClass());
			m.invoke(obj, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static <O, V> void setProperty(O obj, String name, V value) {
		
		try {
			Field field = obj.getClass().getDeclaredField(name);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String nomalizeAttr(String attr) {
		if( attr.length() == 0 )
			return attr;
		if( attr.length() == 1 )
			return attr.toUpperCase();
		return attr.toUpperCase().substring(0, 1) + attr.substring(1, attr.length());
	}
}
