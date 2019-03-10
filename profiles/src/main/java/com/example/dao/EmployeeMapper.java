package com.example.dao;

import org.springframework.jdbc.core.RowMapper;
import com.example.module.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;


/**EMPNO,ENAME,JOB
 * Created by admin on 19-09-2016.
 */
public class EmployeeMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
    	Employee employee = new Employee();
    	employee.setEmpno(resultSet.getString("EMPNO"));
    	employee.setEmpno(resultSet.getString("ENAME"));
    	employee.setEmpno(resultSet.getString("JOB"));
        return employee;
    }
}
