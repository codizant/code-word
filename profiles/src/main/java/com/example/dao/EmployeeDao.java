package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.module.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public String getProcData(){
		try{
				
			Connection 	connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call GET_EMPLOYEES(?,?)}");
			callableStatement.setInt("EMP_NO_INPUT", 7839);
			callableStatement.registerOutParameter("EMP_NAME_OUTPUT", Types.VARCHAR);
			callableStatement.executeUpdate();			  
			String empName = callableStatement.getString("EMP_NAME_OUTPUT");
			System.out.println("empName=>" + empName);			
			connection.close();			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "DONE!!";
	}
	

	
	public void retriveEmployee(){
		System.out.println("------------EmployeeDao::retriveEmployee-------------");
		String sql = "SELECT EMPNO,ENAME,JOB FROM EMP";		
		List<Employee> employees = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		employees.forEach(emp -> System.out.println(emp.toString()));		
	}
	
	
	
	
}
