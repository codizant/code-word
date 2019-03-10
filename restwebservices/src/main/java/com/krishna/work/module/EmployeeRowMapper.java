package com.krishna.work.module;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by admin on 19-09-2016.
 */
public class EmployeeRowMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
    	Employee employee = new Employee();
    	employee.setName(resultSet.getString("ENAME"));
        return employee;
    }
}
