package com.hibernate.guigu.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {
	@Test
	public void Test() {
		SessionFactory sessionFactory = null;
		Configuration configuration = new Configuration().configure();
		// ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		// .applySettings(configuration.getProperties())
		// .buildServiceRegistry();
		sessionFactory = configuration
				.buildSessionFactory(new ServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.buildServiceRegistry());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		News news = new News("Java", "ATGUIGU");

		// News news = new News("Hibernate", "Java", new Date(new
		// java.util.Date().getTime()));

		session.save(news);
		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
