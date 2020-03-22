package com.cognizant.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class MainApp {

	public static void main(String[] args) 
	{	
    	AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(SpringJava.class) ;
    	StudentDaoImpl sdi=(StudentDaoImpl)c.getBean("studentDao");
    	Student s = new Student(109,"Saket",90);
    	System.out.println(sdi.insert(s));
    	System.out.println(sdi.getAll());
    	c.close();
	}
}
