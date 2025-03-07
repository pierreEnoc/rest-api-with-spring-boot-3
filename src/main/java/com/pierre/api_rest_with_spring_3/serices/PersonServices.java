package com.pierre.api_rest_with_spring_3.serices;


import com.pierre.api_rest_with_spring_3.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding on Person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName(" Pierre");
        person.setLastName("Frantz");
        person.setAddress("Sao paulo-  Sao Paulo- Brazil");
        person.setGender("Male");
        return person;
    }

}
