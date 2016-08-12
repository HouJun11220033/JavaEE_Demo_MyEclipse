package com.hibernate.guigu.helloworld;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;
	private Transaction transaction;

	@Test
	public void testComponent() {
		Worker worker = new Worker();
		Pay pay = new Pay();
		pay.setMonthlyPay(1000);
		pay.setYearPay(80000);
		pay.setVocationWithPay(5);

		worker.setName("ABCD");
		worker.setPay(pay);
		session.save(worker);

	}

	@Test
	public void testBlob() throws Exception {
		// News news = new News();
		// news.setAuthor("cc");
		// news.setContent("JDroid");
		// news.setDate(new Date());
		// news.setDesc("DESC");
		// news.setTitle("CC");
		// InputStream stream = new FileInputStream("1.jpg");
		// Blob image = (Blob)
		// Hibernate.getLobCreator(session).createBlob(stream,
		// stream.available());
		// news.setImage(image);
		// session.save(news);
		News news = (News) session.get(News.class, 7);
		Blob imageBlob = (Blob) news.getImage();
		InputStream inputStream = imageBlob.getBinaryStream();
		System.out.println(inputStream.available());

	}

	@Test
	public void testPropertyUpdate() {
		// 在持久化类的配置文件里有: update="false"
		News news = (News) session.get(News.class, 1);
		news.setTitle("aaaa");
		System.out.println(news.getDesc());
		System.out.println(news.getDate().getClass());

	}

	@Test
	public void testIdGenerator() throws InterruptedException {
		News news = new News("AA", "aa", new java.sql.Date(new Date().getTime()));
		session.save(news);

		// Thread.sleep(5000);
	}

	@Test
	public void testDynamicUpdate() {
		// 动态更新，不用调用session方法
		News news = (News) session.get(News.class, 1);
		news.setAuthor("ABCD");
	}

	@Test
	public void testDoWork() {
		session.doWork(new Work() {

			@Override
			// JDBC
			public void execute(java.sql.Connection connection) throws SQLException {
				System.out.println(connection);

			}

		});
	}

	@Test
	public void testEvict() {
		News news1 = (News) session.get(News.class, 1);
		News news2 = (News) session.get(News.class, 2);
		news1.setAuthor("ww");
		news2.setAuthor("ddd");
		// session.evict(news1);
		// session.update(news1);

	}

	@Test
	public void testDelete() {
		News news = (News) session.get(News.class, 3);
		session.delete(news);
		System.out.println(news.getId());

	}

	@Test
	public void testSaveOrUpdate() {
		News news = new News("LLL", "fff", new Date());
		// 若 OID 不为 null, 但数据表中还没有和其对应的记录. 会抛出一个异常.
		// OID和数据库中的ID不一样！！！
		// news.setId(111);
		session.saveOrUpdate(news);

	}

	@Test
	public void testUpdate() {
		News news1 = (News) session.get(News.class, 3);
		// 若数据表中没有对应的记录, 但还调用了 update 方法, 会抛出异常
		// News news2 = new News("FF", "ff", new java.sql.Date(new
		// Date().getTime()));
		transaction.commit();
		session.close();
		news1.setId(6);
		news1.setAuthor("LLL");
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		// news.setAuthor("HouJun");
		session.update(news1);

	}

	@Test
	public void testLoad() {
		// load:懒汉式
		News news = (News) session.load(News.class, 3);
		System.out.println(news.getClass().getName());
		// session.close();
		System.out.println(news);

	}

	@Test
	public void testGet() {
		// 执行 get 方法: 会立即加载对象.
		News news = (News) session.get(News.class, 3);
		session.close();
		System.out.println(news);

	}

	@Test
	public void testPersist() {
		News news = new News();
		news.setTitle("EE");
		news.setAuthor("ee");
		news.setDate(new Date());
		// 和save方法的区别:如果该持久化对象已经有了ID，则不能再setId了
		// news.setId(200);
		session.persist(news);

	}

	@Test
	public void testSave() {
		News news = new News();
		news.setTitle("CC");
		news.setAuthor("cc");
		news.setDate(new Date());
		news.setId(100);
		System.out.println(news);
		session.save(news);
		// 变为持久化对象后，我再试试插入id
		// news.setId(111);

	}

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
		News new1 = new News();
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
		News news1 = new News();
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

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

	}

	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}
