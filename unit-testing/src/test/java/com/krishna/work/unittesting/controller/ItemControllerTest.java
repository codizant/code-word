package com.krishna.work.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

import com.krishna.work.unittesting.module.Item;
import com.krishna.work.unittesting.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { ItemController.class })
public class ItemControllerTest {
	private static Logger logger = LoggerFactory
			.getLogger(ItemControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemService itemService;
	
	@Test
	public void dumyItem() throws Exception {
		logger.info("------------ItemControllerTest :: dumyItem-------------");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getitem")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn();
		
		String expected= "{id:100,name: JavaBook, price :111.0, qty:1}";
		logger.info("actualResult===>" + result.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);		
		//Assert.assertEquals("", result.getResponse().getContentAsString());
	}
	
	@Test
	public void getItemFromBusinessTest() throws Exception {
		logger.info("------------ItemControllerTest :: dumyItem-------------");
		
		when(itemService.getItemFromService()).thenReturn(new Item(101, "SpringBook", 111.0, 5));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemFromService")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:101,name: SpringBook, price :111.0, qty:5}"))
				.andReturn();
		
		//String expected= "{id:101,name: SpringBook, price :111.0, qty:5}";
		
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);		
		
	}
	
}
