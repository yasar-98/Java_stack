package com.yasar.license.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.license.models.Person;

@Repository
public interface PersonRepositry extends CrudRepository<Person, Long>{
    // this method retrieves all the books from the database
    List<Person> findAll();
    // this method finds books with descriptions containing the search string
    List<Person> findByLicenseIdIsNull();
}

