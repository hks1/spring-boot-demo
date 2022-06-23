package com.example.demopayroll;

public class EmployeeNotFoundException extends RuntimeException{

    EmployeeNotFoundException(Long id){
        super(("Could not find employee " + id));
    }
}
