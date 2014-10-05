package org.hippo.sample.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hippo.sample.hibernate.model.Student;
import org.hippo.sample.hibernate.util.HibernateUtil;
import org.junit.Before;
import org.junit.Test;

public class TestDriver {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Student student = new Student(1, "hippo", 43);
		
		//// Configuration ////
		// 1. configuration
		// 2. create session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// 3. open session
		Session session = sessionFactory.openSession();
		// 4. get transaction
		Transaction transaction = session.getTransaction();
		
		//// Operation ////
		// 1. start transaction
		transaction.begin();
		// 2. persistent operation
		session.save(student);
		// 3. commit transaction
		transaction.commit();
		
		
		session.close();
	}

}
