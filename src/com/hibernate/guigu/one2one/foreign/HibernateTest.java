package com.hibernate.guigu.one2one.foreign;

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
	public void testGet2() {
		Manager manager = (Manager) session.get(Manager.class, 1);
		System.out.println(manager.getMgrName());
		System.out.println(manager.getDept().getDeptName());

	}

	@Test
	public void testGet() {
		Department department = (Department) session.get(Department.class, 1);
		System.out.println(department.getDeptName());
		// 懒加载：对关联属性！使用懒加载，是属性！！！
		// session.close();
		System.out.println(department.getMgr());
		Manager manager = department.getMgr();
		System.out.println(manager.getMgrName());

	}

	@Test
	public void testSave() {
		Department department = new Department();
		department.setDeptName("DEPT-AA");
		Manager manager = new Manager();
		manager.setMgrName("MGR-BB");
		department.setMgr(manager);
		manager.setDept(department);
		// 建议先保存没有外键列的那个对象. 这样会减少 UPDATE 语句
		session.save(manager);
		session.save(department);

	}

}
