package com.example.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class EmpCallableStatementCreator {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//"EMP_NO_INPUT", 7839

	
	
	public String getData(){
		SqlParameter empNo = new SqlParameter("EMP_NO_INPUT", Types.INTEGER);
		SqlOutParameter outParameter = new SqlOutParameter("EMP_NAME_OUTPUT", Types.VARCHAR);

		List<SqlParameter> paramList = new ArrayList();
		paramList.add(empNo);
		paramList.add(outParameter);
		
		final String procedureCall = "{call GET_EMPLOYEES(?,?)}";
		
		
		Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection connection)
				throws SQLException {
	
				CallableStatement callableStatement = connection.prepareCall(procedureCall);
				callableStatement.setInt("EMP_NO_INPUT", 7839);
				callableStatement.registerOutParameter("EMP_NAME_OUTPUT", Types.VARCHAR);
				
				return callableStatement;
	
				}
			}, paramList);
		
			System.out.println(">>>"+resultMap.get("EMP_NAME_OUTPUT")+"<<<");
		
		return "OK";
	}

	
	
}
