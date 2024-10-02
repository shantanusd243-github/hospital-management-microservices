package com.employee.management;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.employee.management.model") 
public class Application {

	//logging
	static final Logger logger  = LogManager.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		logger.info("entered application");
		SpringApplication.run(Application.class, args);

	}

}
