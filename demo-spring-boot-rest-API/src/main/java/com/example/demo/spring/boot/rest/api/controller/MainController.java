package com.example.demo.spring.boot.rest.api.controller;

import com.example.demo.spring.boot.rest.api.repo.User;
import com.example.demo.spring.boot.rest.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public @ResponseBody
    Optional<User> getUserById(Integer id){
        logger.info("parameter passed is {}", id);
        return userRepository.findById(id);
    }
}
