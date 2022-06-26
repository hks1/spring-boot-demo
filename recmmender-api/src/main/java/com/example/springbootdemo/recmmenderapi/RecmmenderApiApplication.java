package com.example.springbootdemo.recmmenderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecmmenderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecmmenderApiApplication.class, args);
	}

}

// mvn spring-boot:run

// curl -v http://localhost:8080/actuator | json_pp

/*
{
   "_links" : {
      "health" : {
         "href" : "http://localhost:8080/actuator/health",
         "templated" : false
      },
      "health-path" : {
         "href" : "http://localhost:8080/actuator/health/{*path}",
         "templated" : true
      },
      "self" : {
         "href" : "http://localhost:8080/actuator",
         "templated" : false
      }
   }
}

 */

// curl -v http://localhost:8080/movies | json_pp

// To enable the web exposure of all management endpoints, add the following line to application.properties:
//management.endpoints.web.exposure.include=*

//http://localhost:8081/actuator/metrics
//http://localhost:8081/actuator/mappings

// Since we have enabled the HAL browser, we can view it at http://localhost:8080/browser/index.html#

///actuator/metrics
///actuator/metrics/jvm.memory.used
