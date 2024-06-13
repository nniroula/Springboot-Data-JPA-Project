package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired 
	private CourseJDBCRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/* Fire up insert query. To do this
		 * make this class @Component
		 * use CourseJDBCRepository that you already defined
		 * */
		// in CourseJDBCRepository class - implement insert method and invoke it here
		repository.insert();
		
		repository.deleteById(87);
	}


}
