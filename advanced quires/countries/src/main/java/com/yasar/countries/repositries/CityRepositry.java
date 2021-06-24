package com.yasar.countries.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.countries.models.City;

@Repository
public interface CityRepositry extends CrudRepository<City, Long>{
	   @Query(value="SELECT cities.name FROM cities JOIN countries ON countries.id= cities.country_id where countries.name = \"Mexico\" AND cities.population > '500,000' ORDER BY cities.population DESC;\r\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> findAllMaxicoCityPop();
	    
	    @Query(value="SELECT countries.name as cname , cities.name , cities.district, cities.population FROM cities JOIN countries ON countries.id= cities.country_id where countries.name = \"Argentina\" AND cities.district = \"Buenos Aires\" AND countries.population > '500000' ORDER BY cities.population DESC;\r\n"
		    		+ "", nativeQuery=true)
		    List<Object[]> findSpecificCities();

	
}
