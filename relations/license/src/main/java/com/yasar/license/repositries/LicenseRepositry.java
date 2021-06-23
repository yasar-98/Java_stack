package com.yasar.license.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.license.models.License;

@Repository
public interface LicenseRepositry extends CrudRepository<License, Long>{
    // this method retrieves all the books from the database
    List<License> findAll();
    // this method finds books with descriptions containing the search string
    Optional<License> findByPersonId(long id);
	License findTopByOrderByNumberDesc();
}
