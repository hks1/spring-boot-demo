package com.example.demo.spring.boot.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.spring.boot.rest.api", "com.example.accessingdatamysql"})
public class DemoSpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootRestApiApplication.class, args);
	}

}
