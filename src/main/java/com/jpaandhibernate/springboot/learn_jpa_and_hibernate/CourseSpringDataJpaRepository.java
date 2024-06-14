package com.jpaandhibernate.springboot.learn_jpa_and_hibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.Course;



public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	//custom method
	List<Course> findByAuthor(String author);

}
