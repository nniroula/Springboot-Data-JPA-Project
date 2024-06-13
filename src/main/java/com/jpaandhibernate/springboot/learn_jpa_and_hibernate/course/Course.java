package com.jpaandhibernate.springboot.learn_jpa_and_hibernate.course;

public class Course {
	private long id;
	private String courseName;
	private String author;

	// no arg constructor to avoid start up error
	public Course() {

	}

	// constructor with args
	public Course(long id, String courseName, String author) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.author = author;
	}
	
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	//to string method
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", author=" + author + "]";
	}
}
