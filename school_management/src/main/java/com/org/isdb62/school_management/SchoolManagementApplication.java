package com.org.isdb62.school_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchoolManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(SchoolManagementApplication.class, args);
	}
}