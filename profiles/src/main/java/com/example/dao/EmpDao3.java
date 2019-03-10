package com.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao3 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getData(){
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("GET_EMPLOYEES");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("EMP_NO_INPUT", 7839);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);


		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println("2==>"+simpleJdbcCallResult);
		System.out.println("1==>"+simpleJdbcCallResult.get("EMP_NAME_OUTPUT"));
		
		return "yes";
	}
	
}
