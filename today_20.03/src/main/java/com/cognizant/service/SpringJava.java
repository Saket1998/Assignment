package com.cognizant.service;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

@Configuration
public class SpringJava {

	 @Bean
	 public DataSource dataSourceBean()
	 {
		 DriverManagerDataSource ds=new DriverManagerDataSource();
		 ds.setUsername("root");
		 ds.setPassword("root");
		 ds.setUrl("jdbc:mysql://localhost:3306/student_db");
		 ds.setDriverClassName("com.mysql.jdbc.Driver");
		 return ds;
	 }
	 @Bean
	 public JdbcTemplate jdbcTemplate(DataSource ds) {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
			return jdbcTemplate;
		}
	 
	 @Bean("studentDao")
	 public StudentDao studentDao()
	 {
		 return new StudentDaoImpl();
	 }

}
