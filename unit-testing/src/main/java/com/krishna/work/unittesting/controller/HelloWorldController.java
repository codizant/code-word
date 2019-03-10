package com.krishna.work.unittesting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping("/helloWorld")
	public String HelloWorld(){
		logger.info("---------HelloWorldController :: HelloWorld-----------");
		return "HelloWorld";
	}
	
}
