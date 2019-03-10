package com.krishna.work.topic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


	@GetMapping(path = "/welcome")
	public String getGreetings() {
		return "<h1>!!Hello Pallavi Vedant Krishna!!</h1>";
	}
}
