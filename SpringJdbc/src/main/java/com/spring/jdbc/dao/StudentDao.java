package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {

	public int insert(Student student);
	public int change(Student student);
	public int finish(Student student);
	public Student getStudent(int StudentId);
	public List<Student> getAll();
	
}
