package com.hibernate.guigu.joined.subclass;

import java.util.List;

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
	private Transaction transaction;

	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	/**
	 * 优点: 1. 不需要使用了辨别者列. 2. 子类独有的字段能添加非空约束. 3. 没有冗余的字段.
	 */

	@Test
	public void testQuery() {
		// 对于父类：左外连接
		List<Person> persons = session.createQuery("FROM Person").list();
		System.out.println(persons.size());
		// 对于子类：内连接查询
		List<Student> students = session.createQuery("FROM Student").list();
		System.err.println(students.size());

	}

	@Test
	public void testSave() {
		// 对于子类对象至少需要插入到两张数据表中.
		// Person person = new Person();
		// person.setAge(11);
		// person.setName("AA");
		// session.save(person);
		Student student = new Student();
		student.setAge(40);
		student.setName("CC");
		student.setSchool("GUIGU");
		session.save(student);

	}

}
