package com.hibernate.guigu.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		News news = new News("Java12345", "ATGUIGU");

		// News news = new News("Hibernate", "Java", new Date(new
		// java.util.Date().getTime()));
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(news);
		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
