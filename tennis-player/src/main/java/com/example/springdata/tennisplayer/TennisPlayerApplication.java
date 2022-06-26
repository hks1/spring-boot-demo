package com.example.springdata.tennisplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

//A CommandLineRunner is an interface in Spring Boot which has only one method called run.
// This method is launched as soon as the context is loaded.

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner{

	//logger will display the list of players returned
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//autowire the PlayerDao class to use an object of this class to call the getAllPlayers method inside the run method of the CommandLineRunner
	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		logger.info("All Players Data: {}", dao.getAllPlayer());
	}

}
