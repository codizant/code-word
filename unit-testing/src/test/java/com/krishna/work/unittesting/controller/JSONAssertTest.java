package com.krishna.work.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

	String actual =  "{\"id\":100,\"name\":\"JavaBook\",\"price\":111.0,\"qty\":1}";
	
	@Test
	public void testJson() throws JSONException{
		System.out.println("-----JSONAssertTest :: testJson-----");
		String expected= "{id:100,name: JavaBook, price :111.0, qty:1}";
		
		JSONAssert.assertEquals(expected, actual, false);
	}
	
}
