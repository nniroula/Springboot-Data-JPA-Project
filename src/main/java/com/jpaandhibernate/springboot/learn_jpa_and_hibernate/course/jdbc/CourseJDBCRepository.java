package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository 		// so that it talks to database 
public class CourseJDBCRepository {
	// jdbc template, auto wire it
	@Autowired
	private JdbcTemplate springJdbcTemplate; 	// import JdbcTemplate
	
	// insert qury three double quotes """   """ is called text block
	private static String insertQuery = """ 
				INSERT INTO course(id, courseName, author) VALUES(34, 'Spring/Boot Basics', 'in28minutes');
				
				INSERT INTO course(id, courseName, author) VALUES(99, 'Back-End', 'Online');
				
				INSERT INTO course(id, courseName, author) VALUES(87, 'Java Technologies', 'self taught approach');
			""";

	// method to insert hard coded sql query
	public void insert() {
		springJdbcTemplate.update(insertQuery);
	}
	
	// to execute this query -> Spring boot provides CommandLine Runner. For this, create a new class
	
	// delete method
	private static String DELETE_QUERY = "DELETE FROM course WHERE id = ?;";
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
}
