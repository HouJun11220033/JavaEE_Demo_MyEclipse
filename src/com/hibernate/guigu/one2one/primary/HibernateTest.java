package com.hibernate.guigu.one2one.primary;

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
	public void testGet2()
	{
		Manager manager = (Manager) session.get(Manager.class, 1);
		System.out.println(manager.getMgrId());
		System.out.println(manager.getMgrName());
		System.out.println(manager.getDept().getDeptName());

	}

	@Test
	public void testGet() {
		// 1. 默认情况下对关联属性使用懒加载
		Department dept = (Department) session.get(Department.class, 1);
		System.out.println(dept.getDeptName());

		// 2. 所以会出现懒加载异常的问题.
		Manager mgr = dept.getMgr();
		System.out.println(mgr.getMgrName());
	}

	@Test
	public void testSave() {
		Department department = new Department();
		department.setDeptName("DEPT-DD");
		Manager manager = new Manager();
		manager.setMgrName("MGR-DD");
		department.setMgr(manager);
		manager.setDept(department);
		// 先插入哪一个都不会有多余的 UPDATE
		session.save(department);
		session.save(manager);

	}

}
