package com.hibernate.guigu.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;
	private Transaction tx;

	@Test
	public void testClear() {
		News news1 = (News) session.get(News.class, 1);
		System.out.println(news1);
		session.clear();
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);

	}

	@Test
	public void testRefresh() {
		News news = (News) session.get(News.class, 1);
		System.out.println(news);
		session.refresh(news);
		System.out.println(news);

	}

	@Test
	public void testSesionFlush2() {
		News new1 = new News("Python", "HouJun");
		session.save(new1);

	}

	@Test
	public void testSessionFlush() {
		News news1 = (News) session.get(News.class, 1);
		news1.setAuthor("BBB");
		// session.flush();
		System.out.println(news1);
		News news2 = (News) session.createCriteria(News.class).uniqueResult();
		System.out.println(news2);

	}

	@Test
	public void testSessionCache() {
		News news1 = (News) session.get(News.class, 1);
		News news2 = (News) session.get(News.class, 1);

		System.out.println(news1);
		System.out.println(news2);

	}

	@Test
	public void testCreateTable() {
		News news1 = new News(6, "Java", "CC");
		session.save(news1);
	}

	@Test
	public void Test() {
		// SessionFactory sessionFactory = null;
		// Configuration configuration = new Configuration().configure();
		// ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		// .applySettings(configuration.getProperties())
		// .buildServiceRegistry();
		// sessionFactory = configuration
		// .buildSessionFactory(new ServiceRegistryBuilder()
		// .applySettings(configuration.getProperties())
		// .buildServiceRegistry());
		// Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();

		// News news = new News("Java", "ATGUIGU");

		// News news = new News("Hibernate", "Java", new Date(new
		// java.util.Date().getTime()));

		// session.save(news);
		// tx.commit();
		// session.close();
		// sessionFactory.close();

	}

	@Before
	public void init() {

		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

	}

	@After
	public void destory() {
		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
