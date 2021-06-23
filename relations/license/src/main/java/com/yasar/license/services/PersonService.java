package com.yasar.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.license.models.Person;
import com.yasar.license.repositries.PersonRepositry;

@Service
public class PersonService {
    private final PersonRepositry personRepositry;
    
    public PersonService(PersonRepositry personRepositry) {
        this.personRepositry = personRepositry;
    }
    // returns all the Persons
    public List<Person> allPersons() {
        return personRepositry.findAll();
    }
    public List<Person> personsWithoutLicense() {
        return personRepositry.findByLicenseIdIsNull();
    }
    // creates a Person
    public Person createPerson(Person b) {
        return personRepositry.save(b);
    }
    // retrieves a Person
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepositry.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

}
