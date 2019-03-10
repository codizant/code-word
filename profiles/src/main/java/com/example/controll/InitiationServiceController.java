package com.example.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InitiationServiceController {

	@GetMapping("/method1")
	public String method1(){
		System.out.println("------------InitiationServiceController::method1-------------");
		System.out.println("method1 work inprogress!!");		
		working();
		System.out.println("method1 work Complted!!");
		return "success";
	}
	


	@GetMapping("/method2")
	public void method2(){
		System.out.println("------------InitiationServiceController::method2-------------");
		System.out.println("method2 work inprogress!!");		
		working();
		System.out.println("method2 work Complted!!");
	}
	
	@GetMapping("/method3")
	public void method3(){
		System.out.println("------------InitiationServiceController::method3-------------");
		System.out.println("method3 work inprogress!!");		
		working();
		System.out.println("method3 work Complted!!");
	}
	
	private void working() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
