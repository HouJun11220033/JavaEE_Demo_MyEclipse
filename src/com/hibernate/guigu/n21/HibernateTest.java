package com.hibernate.guigu.n21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.guigu.n21.model.Customer;
import com.hibernate.guigu.n21.model.Order;

public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
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
	public void testUpdate() {
		Order order = (Order) session.get(Order.class, 1);
		order.getCustomer().setCustomerName("JDroid");
		// session.update(order);

	}

	@Test
	public void testDelete() {
		// 还没设置级联
		// 在不设定级联关系的情况下, 且 1 这一端的对象有 n 的对象在引用, 不能直接删除 1 这一端的对象
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);
	}

	@Test
	public void testMany2OneGet() {
		// 1. 若查询多的一端的一个对象, 则默认情况下, 只查询了多的一端的对象. 而没有查询关联的
		// 1 的那一端的对象!
		Order order = (Order) session.get(Order.class, 1);
		System.out.println(order.getOrderName());
		System.out.println(order.getCustomer().getClass().getName());
		// session.close();
		// 2. 在需要使用到关联的对象时, 才发送对应的 SQL 语句.
		// LazyInitializationException 异常
		// 代理对象
		Customer customer = (Customer) session.get(Customer.class, 1);

		System.out.println(customer.getCustomerName());

	}

	@Test
	public void testMany2OneSave() {
		Customer customer = new Customer();
		customer.setCustomerName("AA");
		Order order1 = new Order();
		order1.setOrderName("ORDER-1");
		Order order2 = new Order();
		order2.setOrderName("ORDER-2");
		// 还得设置customer属性啊！！！
		order1.setCustomer(customer);
		order2.setCustomer(customer);

		session.save(customer);
		session.save(order1);
		session.save(order2);
	}

}
