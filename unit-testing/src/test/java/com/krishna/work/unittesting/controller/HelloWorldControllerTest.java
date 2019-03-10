package com.krishna.work.unittesting.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = { HelloWorldController.class })
public class HelloWorldControllerTest {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldControllerTest.class);
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldBasic() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/helloWorld").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		logger.info("===>"+result.getResponse().getContentAsString());
		Assert.assertEquals("HelloWorld", result.getResponse().getContentAsString());
	}
}
