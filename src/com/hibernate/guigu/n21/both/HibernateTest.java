package com.hibernate.guigu.n21.both;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.guigu.n21.both.model.Customer;
import com.hibernate.guigu.n21.both.model.Order;

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
	public void testCascade() {
		// delete-orphan:接触两者的关系,把Order表中的orders删除
		Customer customer = (Customer) session.get(Customer.class, 2);
		customer.getOrders().clear();
	}

	@Test
	public void testDelete() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);
	}

	@Test
	// 通过一这一端去更新多的那一端
	public void testUpdate2() {
		// set是无序的，并不一定先改第一个
		Customer customer = (Customer) session.get(Customer.class, 0);
		customer.getOrders().iterator().next().setOrderName("GGG");

	}
	// 通过多的这一端去更新一的那一端

	@Test
	public void testUpdate() {
		Order order = (Order) session.get(Order.class, 1);
		order.getCustomer().setCustomerName("JDroid");
	}

	@Test
	public void testOne2ManyGet() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getClass().getName());
		System.out.println(customer.getOrders().getClass());
		// System.err.println(customer.getOrders());
		System.out.println(customer.getOrders().size());

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
		Customer customer = order.getCustomer();
		System.out.println(customer.getCustomerName());

		// 3. 在查询 Customer 对象时, 由多的一端导航到 1 的一端时,
		// 若此时 session 已被关闭, 则默认情况下
		// 会发生 LazyInitializationException 异常

		// 4. 获取 Order 对象时, 默认情况下, 其关联的 Customer 对象是一个代理对象!

	}

	@Test
	public void testMany2OneSave() {
		Customer customer = new Customer();
		customer.setCustomerName("AA");


		Order order1 = new Order();
		order1.setOrderName("ORDER-1");

		Order order2 = new Order();
		order2.setOrderName("ORDER-2");
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		session.save(customer);

	}

}
