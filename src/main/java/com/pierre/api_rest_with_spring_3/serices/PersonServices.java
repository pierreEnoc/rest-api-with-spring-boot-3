package com.pierre.api_rest_with_spring_3.serices;


import com.pierre.api_rest_with_spring_3.exception.ResourceNotFoundException;
import com.pierre.api_rest_with_spring_3.model.Person;
import com.pierre.api_rest_with_spring_3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Optional<Person> findById(Long id) {
        logger.info("Finding on Person");
        return Optional.ofNullable(personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID")));
    }

public List<Person> findAll(){
    logger.info("Finding all People");
    return personRepository.findAll();

    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName(" FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Some Addres in Brasil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating on Person");
         return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Update on Person");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("delete on Person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));
        personRepository.delete(entity);
    }
}
