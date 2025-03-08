package com.pierre.api_rest_with_spring_3.repository;

import com.pierre.api_rest_with_spring_3.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
