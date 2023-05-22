package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("StudentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {

		String query = "insert into Student values(?,?,?)";

		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		return r;
	}
	
	public int change(Student student) {

		String query = "update student set name=?,city=? where id =?";
		
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
	}

	public int finish(Student student) {

		String query = "delete from Student where id =? ";
		int result = this.jdbcTemplate.update(query,student.getId());
		return result;
	}
	
	public Student getStudent(int studentId) {

		String query ="select * from Student where id = ? ";
		RowMapper <Student> rowMapper = new RowMapperImpl(); // RowMapper converts resultset obj. to obj.
		Student st = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		
		return st;
	}
	
	public List<Student> getAll() {

		String query = "select * from Student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	

	

}
