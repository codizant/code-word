package com.krishna.work.unittesting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.work.unittesting.module.Item;

@RestController
public class ItemController {
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
		
	@GetMapping("/getitem")
	public Item HelloWorld(){
		logger.info("---------HelloWorldController :: HelloWorld-----------");
		Item item = new Item(100,"JavaBook",111.0,1);
		return item;
	}
	
}
