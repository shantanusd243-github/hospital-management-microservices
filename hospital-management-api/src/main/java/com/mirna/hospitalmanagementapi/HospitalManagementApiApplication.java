package com.mirna.hospitalmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HospitalManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApiApplication.class, args);
	}

}
