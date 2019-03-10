package com.krishna.work.restwebservices;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.krishna.work.configurations.CmacJmsPropeties;
import com.krishna.work.configurations.CmdbProperties;
import com.krishna.work.configurations.DataBaseProperties;

@SpringBootApplication
@ComponentScan("com.krishna.work")
public class RestwebservicesApplication {
	private static Logger logger = LoggerFactory.getLogger(RestwebservicesApplication.class);
	
	@Autowired
    private CmdbProperties cmdbProperties;
	
	@Autowired
	private CmacJmsPropeties cmacJmsPropeties;
	
	@Autowired
	private DataBaseProperties dataBaseProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(RestwebservicesApplication.class, args);
	}
		
	@PostConstruct
    public void init() { 
        logger.info("cmdbProperties ===>"+cmdbProperties.toString());
        logger.info("cmacJmsPropeties ===>"+cmacJmsPropeties.toString());
       // logger.info("dataBaseProperties ===>"+dataBaseProperties.toString());
    }
	
	
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
/*	@Bean
	@Primary
	public DataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(dataBaseProperties.getUsername());
		driverManagerDataSource.setUsername(dataBaseProperties.getPassword());
		driverManagerDataSource.setPassword(dataBaseProperties.getDriverClassName());
	   return driverManagerDataSource;
	}
	*/
	
	// instead of this add a property in application.properties as spring.messages.basename=messages
	/*@Bean 
	public ResourceBundleMessageSource bundleMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}*/
	
}
