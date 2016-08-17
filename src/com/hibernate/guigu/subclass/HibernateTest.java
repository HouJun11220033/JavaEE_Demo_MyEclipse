package com.hibernate.guigu.subclass;

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

	@Test
	public void testQuery() {
		/**
		 * 缺点: 1. 使用了辨别者列. 2. 子类独有的字段不能添加非空约束. 3. 若继承层次较深, 则数据表的字段也会较多.
		 */

		/**
		 * 查询: 1. 查询父类记录, 只需要查询一张数据表 2. 对于子类记录, 也只需要查询一张数据表
		 */
		List<Person> persons = session.createQuery("FROM Person").list();
		System.out.println(persons.size());

		List<Student> stus = session.createQuery("FROM Student").list();
		System.out.println(stus.size());
	}

	@Test
	public void testSave() {
		Person person = new Person();
		person.setAge(11);
		person.setName("AA");

		session.save(person);

		Student stu = new Student();
		stu.setAge(22);
		stu.setName("BB");
		stu.setSchool("ATGUIGU");

		session.save(stu);

	}

}
