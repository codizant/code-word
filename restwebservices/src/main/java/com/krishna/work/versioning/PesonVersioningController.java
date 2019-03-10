package com.krishna.work.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesonVersioningController {

	//Approach 1 
	
	@GetMapping("v1/person")
	public Person1 Person1(){
		return new Person1("Pallavi");
	}

	
	@GetMapping("v2/person")
	public Person2 getPerson2(){
		return new Person2(new Name("Pallavi","Dhote"));
	}
	
	//Approach 2
	//http://localhost:8085/person/param?version=1
	@GetMapping(value= "person/param", params= "version=1")
	public Person1 Param1(){
		return new Person1("Pallavi");
	}

	//http://localhost:8085/person/param?version=2
	@GetMapping(value= "person/param", params= "version=2")
	public Person2 Param2(){
		return new Person2(new Name("Pallavi","Dhote"));
	}
	
	//Approach 3
	
	@GetMapping(value= "person/header", headers= "X-API-VERSION=1")
	public Person1 HeaderV1(){
		return new Person1("Pallavi");
	}
	
	@GetMapping(value= "person/produces", headers= "X-API-VERSION=2")
	public Person2 HeaderV2(){
		return new Person2(new Name("Pallavi","Dhote"));
	}
	
	
	//Approach 4
	
	@GetMapping(value= "person/produces", produces= "application/vnd.company.app-v1+json")
	public Person1 ProducesV1(){
		return new Person1("Pallavi");
	}
	
	@GetMapping(value= "person/produces", produces= "application/vnd.company.app-v2+json")
	public Person2 ProducesV2(){
		return new Person2(new Name("Pallavi","Dhote"));
	}
	
}
