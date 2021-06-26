package com.yasar.dojo.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.dojo.models.Dojo;

//...
@Repository
public interface DojoRepositry extends CrudRepository<Dojo, Long>{
 List<Dojo> findAll();
 
}
