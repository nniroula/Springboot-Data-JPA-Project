package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	// To use JPA, you have to use EntityManage
	
	//@Autowired -> better than autowired is @PeristenceContext
	@PersistenceContext
	private EntityManager entityManager;
	
	// insert row into db table
	public void insert(Course course) {
		entityManager.merge(course);  // mapping is already done
	}
	
	// find a course by id
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	//delete a course by id
	public void deleteById(long id) {
		//find a course by id and remove it
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
}


