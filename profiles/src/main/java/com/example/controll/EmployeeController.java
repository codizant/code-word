package com.example.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmpCallableStatementCreator;

@RestController
public class EmployeeController {

	@Autowired
	private EmpCallableStatementCreator employeeDao;

	
	@GetMapping("/employee")
	public void getEmpData(){		
		System.out.println("-------EmployeeController::getEmpData---------");
	
		String ename =employeeDao.getData();
		System.out.println(ename+"<<<================");
		
	}
}
