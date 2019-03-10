package com.krishna.work.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cmac.jms")
public class CmacJmsPropeties {

	//@Value("${cmac.jms.prop1}")
	private String prop1;
	
	//@Value("${cmac.jms.prop2}")
	private String prop2;

	
	public String getProp1() {
		return prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	@Override
	public String toString() {
		return "CmacJmsPropeties \n [prop1=" + prop1 + ", prop2=" + prop2 + "]";
	}
	
	
}
