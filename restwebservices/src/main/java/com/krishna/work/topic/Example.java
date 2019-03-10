package com.krishna.work.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

	@RequestMapping("/")
	String home() {
		System.out.println("I m Example:home !");
		return "<h1>!!Hello Pallavi Vedant Krishna!!</h1>";
	}

}