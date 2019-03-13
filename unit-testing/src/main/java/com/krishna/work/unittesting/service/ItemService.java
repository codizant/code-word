package com.krishna.work.unittesting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.krishna.work.unittesting.dao.ItemDao;
import com.krishna.work.unittesting.module.Item;

@Service
public class ItemService {
	private static Logger logger = LoggerFactory.getLogger(ItemService.class);
	private String CLASS_NAME = "ItemService";

	private ItemDao itemDao; 
	
	public Item getItemFromService() {
		String methodName = "getItemFromService";
		logger.info("Start Class : {} Method : {} ", CLASS_NAME, methodName);
		Item item = itemDao.getItem(); 
		logger.info("End Class : {} Method : {} item :{}", CLASS_NAME, methodName, item.toString());
		return item;
	}

}
