package com.krishna.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.work.dao.EmployeeDao;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao; 
	
	
	@GetMapping("/employee")
	public void getEmployee(){
		System.out.println("-------EmployeeController::getEmployee------");
		//employeeDao.getAllEmployees();
	}
	
}
