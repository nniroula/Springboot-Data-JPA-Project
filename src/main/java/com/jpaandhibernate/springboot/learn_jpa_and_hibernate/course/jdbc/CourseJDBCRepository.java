package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.Course;

@Repository // so that it talks to database
public class CourseJDBCRepository {
	// jdbc template, auto wire it
	@Autowired
	private JdbcTemplate springJdbcTemplate; // import JdbcTemplate

	/*
	 * Static values for insert query // insert qury three double quotes """   """
	 * is called text block private static String insertQuery = """ INSERT INTO
	 * course(id, courseName, author) VALUES(34, 'Spring/Boot Basics',
	 * 'in28minutes'); INSERT INTO course(id, courseName, author) VALUES(99,
	 * 'Back-End', 'Online'); INSERT INTO course(id, courseName, author) VALUES(87,
	 * 'Java Technologies', 'self taught approach'); """;
	 */
	// dynamic values for insert query
	private static String insertQuery = """
				INSERT INTO course(id, courseName, author) VALUES(?, ?, ?);
			""";
	// to execute sql query -> Spring boot provides CommandLine Runner. For this,
	// create a new class
	// method to insert hard coded sql query
	//	public void insert() {
	//		springJdbcTemplate.update(insertQuery);
	//	}

	/*
	 * static approach for CRUD insertion public void insert() {
	 * springJdbcTemplate.update(insertQuery); }
	 */

	// dynamic approach
	public void insert(Course course) {
		springJdbcTemplate.update(insertQuery, course.getId(), course.getCourseName(), course.getAuthor());
	}

	// delete method
	private static String DELETE_QUERY = "DELETE FROM course WHERE id = ?;";

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	// retrieve data from database
	private static String SELECT_QUERY = "SELECT * FROM course WHERE id = ?;";

	// method to execute this select query, select query gives Course back here
	public Course findById(long id) {
		// convert select query result from ResultSet to Bean to Row Mapper
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
