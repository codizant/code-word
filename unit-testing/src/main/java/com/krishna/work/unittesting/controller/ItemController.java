package com.krishna.work.unittesting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.work.unittesting.module.Item;
import com.krishna.work.unittesting.service.ItemService;

@RestController
public class ItemController {
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);
		
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/getitem")
	public Item HelloWorld(){
		logger.info("---------ItemController :: HelloWorld-----------");
		Item item = new Item(100,"JavaBook",111.0,1);
		return item;
	}
	
	@GetMapping("/getItemFromService")
	public Item getItemFromService(){
		logger.info("Start---------ItemController :: getItemFromService-----------");
		Item item=	itemService.getItemFromService();
		logger.info("End---------ItemController :: getItemFromService-----------");
		return item;
	}
	
}
