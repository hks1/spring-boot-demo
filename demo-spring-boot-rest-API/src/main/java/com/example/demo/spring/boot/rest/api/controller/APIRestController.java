package com.example.demo.spring.boot.rest.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class APIRestController {

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello World! from spring boot REST API";
    }
}
