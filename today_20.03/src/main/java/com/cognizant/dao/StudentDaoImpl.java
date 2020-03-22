package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cognizant.model.Student;

@Component
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insert(Student s) {
		// TODO Auto-generated method stub
		System.out.println(s);
		int r=jdbcTemplate.update(
		        "insert into student (id,name,marks) values (?,?,?)",
		        s.getId(),s.getName(),s.getMarks());
		if(r>0)
		return "SUCCESS";
		else
			return "FAIL";
	}
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> actors = jdbcTemplate.query(
		        "select * from student",
		        new RowMapper<Student>() {
		            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		                Student actor = new Student();
		                actor.setId(rs.getInt("id"));
		                actor.setName(rs.getString("name"));
		                actor.setMarks(rs.getInt("marks"));
		                return actor;
		            }
		        });
		return actors;
	}
}
