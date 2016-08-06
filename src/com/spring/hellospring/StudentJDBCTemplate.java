package com.spring.hellospring;

import com.model.Student;
import com.model.StudentMarks;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;

public class StudentJDBCTemplate implements StudentDAO {

	// private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	// private SimpleJdbcCall jdbcCall;
	// private PlatformTransactionManager transactionManager;

	// public PlatformTransactionManager getTransactionManager() {
	// return transactionManager;
	// }
	//
	// public void setTransactionManager(PlatformTransactionManager
	// transactionManager) {
	// this.transactionManager = transactionManager;
	// }

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	// public SimpleJdbcCall getJdbcCall() {
	// return jdbcCall;
	// }
	//
	// public void setJdbcCall(SimpleJdbcCall jdbcCall) {
	// this.jdbcCall = jdbcCall;
	// }

	@Override
	public void setDataSource(DataSource dataSource) {

		// this.jdbcCall = new
		// SimpleJdbcCall(dataSource).withProcedureName("getRecord");
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	public void create(String name, Integer age, Integer marks, Integer year) {
		// TransactionDefinition def = new DefaultTransactionDefinition();
		// TransactionStatus status = transactionManager.getTransaction(def);
		// JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		// String SQL = "insert into Student(name,age) values (?,?)";
		// jdbcTemplateObject.update(SQL, name, age);
		// System.out.println("Create Record Name=" + name + "Age=" + age);
		// try {
		// String SQL1 = "insert into Student (name, age) values (?, ?)";
		// jdbcTemplateObject.update(SQL1, name, age);
		//
		// // Get the latest student id to be used in Marks table
		// String SQL2 = "select max(id) from Student";
		// int sid = jdbcTemplateObject.queryForInt(SQL2);
		//
		// String SQL3 = "insert into Marks(sid, marks, year) "
		// + "values (?, ?, ?)";
		// jdbcTemplateObject.update(SQL3, sid, marks, year);
		//
		// System.out.println("Created Name = " + name + ", Age = " + age);
		// // to simulate the exception.
		// throw new RuntimeException("simulate Error condition");
		// } catch (DataAccessException e) {
		// System.out.println("Error in creating record, rolling back");
		// throw e;
		// }
		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplateObject.queryForInt(SQL2);

			String SQL3 = "insert into Marks(sid, marks, year) "
					+ "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3, sid, marks, year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			// to simulate the exception.
			throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	// @Override
	// public Student getStudent(Integer id) {
	// SqlParameterSource in = new MapSqlParameterSource().addValue("in_id",
	// id);
	// Map<String, Object> out = jdbcCall.execute(in);
	// // String SQL = "select * from Student where id=?";
	// //Student student = jdbcTemplateObject.queryForObject(SQL, new
	// Object[]{id}, new StudentMapper());
	// Student student = new Student();
	// student.setId(id);
	// student.setName((String) out.get("out_name"));
	// student.setAge((Integer) out.get("out_age"));
	// return student;
	//
	// }

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student,Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
				new StudentMarksMapper());
		return studentMarks;

	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age=? where id=?";
		jdbcTemplateObject.update(SQL, id, age);
		System.out.println("Updated Record with ID = " + id);
		return;

	}

	// 难道必须实现这个接口方法吗？？？

	@Override
	public void create(String name, Integer age) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public Student getStudent(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

}
