package com.pierre.api_rest_with_spring_3.serices;


import com.pierre.api_rest_with_spring_3.data.dto.PersonDTO;
import com.pierre.api_rest_with_spring_3.exception.ResourceNotFoundException;
import static com.pierre.api_rest_with_spring_3.mapper.ObjectMapper.*;
import com.pierre.api_rest_with_spring_3.model.Person;
import com.pierre.api_rest_with_spring_3.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public PersonDTO findById(Long id) {
        logger.info("Finding on Person");

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));
       return parseObjects(entity, PersonDTO.class);
    }

public List<PersonDTO> findAll(){
    logger.info("Finding all People");
    return parseListObjects(personRepository.findAll(), PersonDTO.class);

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

    public PersonDTO create(PersonDTO person){
        logger.info("Creating on Person");
        var entity = parseObjects(person, Person.class);
        return parseObjects(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Update on Person");
        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObjects(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("delete on Person");
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no record found for this ID"));
        personRepository.delete(entity);
    }
}
