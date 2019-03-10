package com.example.dao;

import java.sql.Types;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    private EmployeeSP  sproc;
   
    public void setDataSource(DataSource source){
            this.sproc = new EmployeeSP(jdbcTemplate.getDataSource());
    }
	
    /*
     * wraps stored procedure call
     */
        public String getEmployeeName(int emp_id){
                return (String) sproc.execute(7839);
        }
       
        /*
         * Inner class to implement stored procedure in spring.
         */
        
        
        private class EmployeeSP extends StoredProcedure{
	        private static final String SPROC_NAME = "GET_EMPLOYEES";
	       
	        public EmployeeSP( DataSource datasource ){
	                super( datasource, SPROC_NAME );
	                declareParameter( new SqlParameter( "EMP_NO_INPUT", Types.INTEGER) ); 
	                //declaring sql in parameter to pass input
	
	                declareParameter( new SqlOutParameter( "EMP_NAME_OUTPUT", Types.VARCHAR ) ); 
	                //declaring sql out parameter
	                
	                compile();
	        }
	       
	        public Object execute(int emp_id){
	                Map<String,Object> results = super.execute(emp_id);
	                System.out.println("===>"+results.get("EMP_NAME_OUTPUT"));
	                return results.get("EMP_NAME_OUTPUT"); //reading output of stored procedure using out parameters                                               
	        }
}
	
	
	
	
	
	
	
	
	
	
	
/*	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	
 * 
 * public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("GET_EMPLOYEES");
	   }
	 */
	 
	/* public void getEmp() {
		 
	      SqlParameterSource in = new MapSqlParameterSource().addValue("EMP_NO_INPUT", 7839);
	      Map<String, Object> out = jdbcCall.execute(in);

	      Employee emp = new Employee();
	      emp.setEmpno("7839");
	      emp.setEname((String) out.get("EMP_NAME_OUTPUT"));	      
	      System.out.println("=======>"+emp.toString());
	      
	   }*/
}
