package com.example.demo.spring.boot.rest.api.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.context.annotation.Bean;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository  extends CrudRepository<User, Integer>{
//public interface UserRepository  extends JpaRepository<User, Integer>{
    List<User> findByName(String name);

    //User findById(Integer id);
}
