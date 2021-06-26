package com.yasar.dojo.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.dojo.models.Ninja;

@Repository
public interface NinjaRepositry extends CrudRepository<Ninja, Long>{
	 List<Ninja> findAll();
	 @Query(value="SELECT * FROM ninjas JOIN dojos ON dojos.id = ninjas.dojo_id WHERE dojos.id = ?1 ", nativeQuery=true)
	 List<Ninja> allNinjasdojo(Long id);
 
}

