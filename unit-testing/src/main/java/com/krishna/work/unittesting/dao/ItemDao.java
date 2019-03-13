package com.krishna.work.unittesting.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.krishna.work.unittesting.controller.ItemController;
import com.krishna.work.unittesting.module.Item;

@Component
public class ItemDao {
	private static Logger logger = LoggerFactory
			.getLogger(ItemController.class);

	public Item getItem() {
		logger.info("S-------ItemDao::getItem----------");
		Item item = new Item(101, "SpringBook", 111.0, 5);
		logger.info("E-------ItemDao::getItem----------");
		return item;
	}
}
