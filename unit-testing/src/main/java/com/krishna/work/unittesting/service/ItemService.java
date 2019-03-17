package com.krishna.work.unittesting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.krishna.work.unittesting.dao.ItemDao;
import com.krishna.work.unittesting.module.Item;

@Component
public class ItemService {
	private static Logger logger = LoggerFactory.getLogger(ItemService.class);
	private String CLASS_NAME = "ItemService";

	@Autowired
	private ItemDao itemDao; 
	
	public Item getItemFromService() {
		String methodName = "getItemFromService";
		logger.info("Start Class : {} Method : {} ", CLASS_NAME, methodName);
		Item item = itemDao.getItem(); 
		logger.info("End Class : {} Method : {} item :{}", CLASS_NAME, methodName, item.toString());
		return item;
	}

}
