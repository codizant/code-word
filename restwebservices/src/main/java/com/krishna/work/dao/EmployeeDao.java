package com.krishna.work.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.krishna.work.module.Employee;
import com.krishna.work.module.EmployeeRowMapper;

@Repository
public class EmployeeDao {/*

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

    public void getAllEmployees(){
        System.out.println("EmployeeDao.getAllEmployees");
        String sql="SELECT * FROM EMP";
        List<Employee> employee=jdbcTemplate.query(sql,new EmployeeRowMapper());
        for (Employee emp : employee){
            System.out.println(emp.toString());
        }
    }
*/}
