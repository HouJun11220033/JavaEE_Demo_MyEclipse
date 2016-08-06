package com.spring.hellospring;

import com.spring.tutorialspoint.model.HelloWorld;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	static Logger log = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = new
		// ClassPathXmlApplicationContext("Beans.xml");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		log.info("Going to creat HelloWorld Obj");
		HelloWorld obj = (HelloWorld) ac.getBean("helloWorld");
		obj.getMessage1();
		obj.getMessage2();
		log.info("Exiting the program");
		// StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
		// ac.getBean("studentJDBCTemplate");
		// System.out.println("---------------------Records Creation----------------------------");
		// studentJDBCTemplate.create("Zara", 11, 99, 2010);
		// studentJDBCTemplate.create("Nuha", 20, 97, 2010);
		// studentJDBCTemplate.create("Ayan", 25, 100, 2011);
		// System.out.println("--------------------------Listing Multiple Records----------------------------");
		// List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		// for (StudentMarks record : studentMarks) {
		// System.out.print("ID : " + record.getId());
		// System.out.print(", Name : " + record.getName());
		// System.out.print(", Marks : " + record.getMarks());
		// System.out.print(", Year : " + record.getYear());
		// System.out.println(", Age : " + record.getAge());
		//
		// }
		// System.out.println("----Updating Record with ID = 2 -----");
		// studentJDBCTemplate.update(2, 20);
		// System.out.println("------------------------Listing Record with ID = 2 -------------------------");
		// Student student = studentJDBCTemplate.getStudent(2);
		// System.out.print("ID : " + student.getId());
		// System.out.print(", Name : " + student.getName());
		// System.out.println(", Age : " + student.getAge());

		// ApplicationContext ac_1 = new
		// AnnotationConfigApplicationContext(HelloWorldConfig.class);
		// ApplicationContext ac_2 = new
		// AnnotationConfigApplicationContext(TextEditorConfig.class);
		// AbstractApplicationContext context = new
		// ClassPathXmlApplicationContext("Beans.xml");
		// CustomEventPublisher cep = (CustomEventPublisher)
		// context.getBean("customEventPublisher");
		// cep.publish();
		// cep.publish();
		// context.start();
		// 换用AbstractApplicationContext对象时，可以调用销毁方法。。。
		// 在非Web应用中，手工加载Spring
		// IoC容器，不能用ApplicationContext，要用AbstractApplicationContext。用完以后要记得调用ctx.close()关闭容器。如果不记得关闭容器，最典型的问题就是数据库连接不能释放
		// HelloWorld hw = (HelloWorld) context.getBean("helloworld_1");
		// HelloWorld hw_1 = (HelloWorld) context.getBean("helloworld");
		// HelloChina hc_1 = (HelloChina) context.getBean("hellochina");
		// HelloWorld helloworld = ac_1.getBean(HelloWorld.class);
		// TextEditor te = ac_2.getBean(TextEditor.class);
		// TextEditor te = (TextEditor) ac.getBean("textEditor");
		// helloworld.setMessage1("Hello World!");
		// helloworld.getMessage1();
		// context.stop();
		// Profile pro=(Profile) ac.getBean("profile");
		// JavaCollection jc = (JavaCollection) ac.getBean("javaCollection");
		// Student stu = (Student) ac.getBean("student");
		// stu.getName();
		// stu.getAge();
		// stu.printThrowException();
		// hw.setMessage("I am object hw");
		// hw.destory();
		// hw.getMessage();
		// BeanPostProcessor接口对每一个在XML文件中配置的Bean都有效
		// hw_1.getMessage1();
		// hw_1.getMessage2();
		// System.out.println("----------------------------------------------------------");
		// hc_1.getMessage1();
		// hc_1.getMessage2();
		// hc_1.getMessage3();
		// te.getSpellChecker();
		// te.setSpellChecker(spellChecker);
		// jc.getAddrList();
		// jc.getAddrMap();
		// properties对象返回的必须是两个string类型的
		// jc.getAddrProp();
		// jc.getAddrSet();
		// System.out.println("Name : " + stu.getName());
		// System.out.println("Age : " + stu.getAge());
		// te.spellCheck();
		// pro.printAge();
		// pro.printName();
		// context.registerShutdownHook();
		// 在非Web应用中关闭Ioc容器，需要调用registerShutdownHook方法
	}

}
