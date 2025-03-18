package com.pierre.api_rest_with_spring_3.controllers;

import com.pierre.api_rest_with_spring_3.data.dto.PersonDTO;
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
    public PersonDTO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDTO> findAll() {
        return services.findAll();
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create( @RequestBody PersonDTO person) {
        return services.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update( @RequestBody PersonDTO person) {
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
         services.delete(id);
         return ResponseEntity.noContent().build();
    }

}
