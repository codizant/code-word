package com.krishna.work.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean(){
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean(){		
		List<SomeBean> someBeanList = new ArrayList<SomeBean>();
		someBeanList.add(new SomeBean("value1","value2","value3"));
		someBeanList.add(new SomeBean("value12","value22","value32"));
		return someBeanList ; 		
	}
}
