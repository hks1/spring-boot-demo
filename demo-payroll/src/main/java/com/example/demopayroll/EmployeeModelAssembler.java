package com.example.demopayroll;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>>{
    @Override
    public EntityModel<Employee> toModel(Employee employee){
        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}

/*
This simple interface has one method: toModel(). It is based on converting a non-model object (Employee) into a model-based object (EntityModel<Employee>).
 */

/*
Spring HATEOAS’s abstract base class for all models is RepresentationModel. But for simplicity, I recommend using EntityModel<T> as your mechanism to easily wrap all POJOs as models.
 */
