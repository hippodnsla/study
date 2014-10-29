package org.hippo.sample.j2se.reflection.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Factory {

	public static Fruit getInstance(String name) {
		Class<? extends Fruit> fruitClass = lookup(name);
		if( fruitClass == null )
			return null;
		try {
			return fruitClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Class<? extends Fruit> lookup(String name) {
		String className = loadClassName(name);
		if( className == null )
			return null;
		try {
			Class<?> clazz = Class.forName(className);
			return (Class<? extends Fruit>) clazz;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String loadClassName(String name) {
		Properties propt = new Properties();
        File f = new File("fruit.properties");

        //if( !f.exists() )
        //	return null;
        
        try {
			propt.load(new FileInputStream(f));
			return propt.getProperty(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
}
