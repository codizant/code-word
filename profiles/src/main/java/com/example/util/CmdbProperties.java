package com.example.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cmdb")
public class CmdbProperties {
	
    
	private String resourceUrl;

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	@Override
	public String toString() {
		return "CmdbProperties [resourceUrl=" + resourceUrl + "]";
	}
    
    
	
}
