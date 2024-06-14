package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.CourseSpringDataJpaRepository;
import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.Course;
import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJDBCRepository;
import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;


//@Component
//public class CourseJdbcCommandLineRunner implements CommandLineRunner{


// rename it with to use with JPA
@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired 
//	private CourseJDBCRepository repository;
//	
	// use Course JPA Repository
//	@Autowired 
//	private CourseJpaRepository repository;

	// for Spring Data JPA
	@Autowired 
	private CourseSpringDataJpaRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/* Fire up insert query. To do this
		 * make this class @Component
		 * use CourseJDBCRepository that you already defined
		 * */
		// in CourseJDBCRepository class - implement insert method and invoke it here
		// repository.insert();
//		repository.insert(new Course(1, "learn JS", "JS Online"));
//		repository.insert(new Course(2, "learn JAVA", "Java Self"));
//		repository.insert(new Course(3, "Backend", "Coding Bootcamp"));
		
//		repository.deleteById(1);
//		
//		// findById
//		System.out.println(" ***** Select query output ....... ******* ");
//		System.out.println(repository.findById(3));
		
		
		// Spring Data JPA mehtods
		repository.save(new Course(1, "learn JS", "JS Online")); 
		repository.save(new Course(2, "learn JAVA", "Java Self"));
		repository.save(new Course(3, "Backend", "Coding Bootcamp"));
		
		
		repository.deleteById(1L);
		
		// findById
		System.out.println(" ***** Select query output ....... ******* ");
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		// custom Spring data jpa method
		System.out.println(repository.findByAuthor("Java Self"));
		System.out.println(repository.findByAuthor(""));
	}


}
