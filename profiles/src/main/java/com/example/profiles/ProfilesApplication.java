package com.example.profiles;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.util.CmdbProperties;
import com.example.util.DatabaseProperties;

@SpringBootApplication(scanBasePackages={"com.example"})
public class ProfilesApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(ProfilesApplication.class);
	@Autowired
	private Environment env;
	@Autowired
    private CmdbProperties cmdbProperties;
	@Autowired
	private DatabaseProperties databaseProperties;
	public static void main(String[] args) {
		LOGGER.info("------------main------------");
		SpringApplication.run(ProfilesApplication.class, args);		
	}
	
	@PostConstruct
	public void init(){
		LOGGER.info("----------------------------------------------------------------");
		LOGGER.info(cmdbProperties.toString());
		LOGGER.info(databaseProperties.toString());
		LOGGER.info(env.getProperty("app.name"));
		LOGGER.info(env.getProperty("app.description"));
		LOGGER.info(env.getProperty("mydb.url"));
		LOGGER.info("----------------------------------------------------------------");
	}
	
	@Bean
    public DataSource datasource() {
				
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl(databaseProperties.getUrl());
        dataSource.setUsername(databaseProperties.getUsername());
        dataSource.setPassword(databaseProperties.getPassword());
        
        return dataSource;
    }
}

