package com.krishna.work.unittesting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.krishna.work.unittesting.dao.ItemDao;
import com.krishna.work.unittesting.module.Item;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerTestIT {

	private static Logger logger = LoggerFactory
			.getLogger(ItemControllerTestIT.class);

	@Autowired
	private TestRestTemplate restTemplate;

	
	@MockBean
	private ItemDao itemDao;
	
	@Test
	public void testCase() {
		logger.info("Start:--------ItemControllerTestIT::testCase---------");
		Item item = (Item) this.restTemplate.getForObject("/getitem",
				Item.class);
		logger.info("item=>\t" + item);
		logger.info("End:--------ItemControllerTestIT::testCase---------");
	}
	
	//getItemFromService
	@Test
	public void getItemFromServiceTest() {
		logger.info("Start:--------ItemControllerTestIT::getItemFromServiceTest---------");
		when(itemDao.getItem()).thenReturn(new Item(110, "SpringBook", 555.0, 5));
		
		Item item = (Item) this.restTemplate.getForObject("/getItemFromService",
				Item.class);
		logger.info("item=>\t" + item);
		logger.info("End:--------ItemControllerTestIT::getItemFromServiceTest---------");
	}
	
}
