package org.hippo.sample.hibernate.util;


import java.io.IOException;

import org.hippo.sample.hibernate.myhibernate.Configuration;
import org.hippo.sample.hibernate.myhibernate.SessionFactory;
import org.jdom.JDOMException;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (JDOMException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (SecurityException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
