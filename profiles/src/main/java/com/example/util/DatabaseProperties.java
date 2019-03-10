package com.example.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DatabaseProperties {

	private String url;
	private String username;
	private String password;
	private String driverClass="oracle.jdbc.driver.OracleDriver" ;
	
	
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	
	@Override
	public String toString() {
		return "DatabaseProperties [url=" + url + ", username=" + username
				+ ", password=" + password + ", driverClass=" + driverClass
				+ "]";
	}
	
}
