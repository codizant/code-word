package com.krishna.work.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONAssertTest {
	private static Logger logger = LoggerFactory
			.getLogger(JSONAssertTest.class);
	
	String actual =  "{\"id\":100,\"name\":\"JavaBook\",\"price\":111.0,\"qty\":1}";
	
	@Test
	public void testJson() throws JSONException{
		
		logger.info("-----JSONAssertTest :: testJson-----");
		String expected= "{id:100,name: JavaBook, price :111.0, qty:1}";
		
		JSONAssert.assertEquals(expected, actual, false);
		
	}
	
}
