package com.example.demopayroll;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

/*
Spring Data’s repository solution (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories) makes it possible to sidestep data store specifics and instead solve a majority of problems using domain-specific terminology.


 */
