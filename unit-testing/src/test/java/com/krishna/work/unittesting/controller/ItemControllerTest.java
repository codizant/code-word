package com.krishna.work.unittesting.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.test.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { ItemController.class })
public class ItemControllerTest {
	private static Logger logger = LoggerFactory
			.getLogger(ItemControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void dumyItem() throws Exception {
		logger.info("------------ItemControllerTest :: dumyItem-------------");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getitem")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("")).andReturn();
				

		logger.info("===>" + result.getResponse().getContentAsString());
		Assert.assertEquals("", result.getResponse().getContentAsString());
	}
}
