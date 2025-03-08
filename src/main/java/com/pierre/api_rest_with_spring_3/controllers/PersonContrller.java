package com.pierre.api_rest_with_spring_3.controllers;

import com.pierre.api_rest_with_spring_3.model.Person;
import com.pierre.api_rest_with_spring_3.serices.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonContrller {

    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Person> findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll() {
        return services.findAll();
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create( @RequestBody Person person) {
        return services.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update( @RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
         services.delete(id);
         return ResponseEntity.noContent().build();
    }

}
