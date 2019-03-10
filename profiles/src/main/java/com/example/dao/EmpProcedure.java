package com.example.dao;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.example.module.Employee;

public class EmpProcedure extends StoredProcedure {

	@Autowired
	private DataSource dataSource;
	
	 public EmpProcedure(){}
	 
	  public EmpProcedure(DataSource dataSource){
	      super(dataSource,"GET_EMPLOYEES");
	      declareParameter(new SqlParameter("EMP_NO_INPUT", Types.INTEGER));
	      declareParameter(new SqlOutParameter("EMP_NAME_OUTPUT", Types.VARCHAR));
	      compile();
	   }
	  
	   public void execute(){
	      Map<String, Object> out = super.execute(7839);
	      Employee emp = new Employee();
	      emp.setEmpno("7839");
	      emp.setEname((String) out.get("EMP_NAME_OUTPUT"));
	      
	      System.out.println(emp.toString());
	      
	   }
	   
}
