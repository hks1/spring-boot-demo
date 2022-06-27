package com.example.springdatajpa.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

//A CommandLineRunner is an interface in Spring Boot which has only one method called run.
// This method is launched as soon as the context is loaded.

@SpringBootApplication
public class TennisPlayerApplication {

	//logger will display the list of players returned
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}



}
