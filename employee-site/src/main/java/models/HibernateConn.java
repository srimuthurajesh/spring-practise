package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConn {
	private static SessionFactory factory;

	public HibernateConn() {
		if (factory == null)
			factory = new Configuration().configure("models/hibernate.cfg.xml").addAnnotatedClass(Employee.class)
					.buildSessionFactory();

	}

	Session getHibernateSession() {
		// create session
		return factory.getCurrentSession();
	}

	void closeFactory() {
		factory.close();
	}
}
