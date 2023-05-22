package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
    
    	StudentDao studentDao = context.getBean("StudentDao",StudentDao.class);
    	
         Student student = new Student();
         
         //insert
		
		/*
		 * student.setId(6); student.setName("Ajay"); student.setCity("Rurkee");
		 * 
		 * int result = studentDao.insert(student);
		 * 
		 * 
		 * System.out.println("number of record inserted " + result);
		 */
         //update
		
		/*
		 * student.setName("Dheeraj"); student.setId(3); student.setCity("Rau");
		 * 
		 * int result = studentDao.change(student);
		 * System.out.println("change successfully " + result);
		 * 
		 */    //delete
        
		/*
		 * student.setId(3); int finish = studentDao.finish(student);
		 * System.out.println("finish "+finish);
		 * 
		 */ 
         
        // get single object;
		/*
		 * Student student1 = studentDao.getStudent(1); System.out.println(student1);
		 */
         
         //getAlldata
         List<Student> Students = studentDao.getAll();
         for(Student s:Students) {
        	 System.out.println(s);
         }
    }
}
