package com.yasar.countries.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.countries.models.Country;

@Repository
public interface CountryRepositry extends CrudRepository<Country, Long>{
	   @Query(value="SELECT countries.name,languages.language,languages.percentage FROM countries JOIN languages ON countries.id= languages.country_id where languages.language = \"Slovene\" ORDER BY languages.percentage DESC;\r\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> findAllCountriesWithLanguageSlovene();
	    @Query(value="SELECT countries.name,COUNT(cities.country_id) AS NumberOfCities FROM countries JOIN cities ON countries.id= cities.country_id GROUP BY countries.id ORDER BY NumberOfCities DESC;\r\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> findAllCountriesWithNumofCity();
	    
	    @Query(value="SELECT countries.name FROM countries where countries.surface_area < '501.0' and countries.population > '100000';\r\n"
	    		+ "", nativeQuery=true)
	    List<String> findSpecefiedCountries();
	    @Query(value="SELECT countries.name FROM countries where countries.surface_area > '200.0' and countries.life_expectancy > '75' and countries.government_form = \"Monarchy (Sultanate)\"   ;\r\n"
	    		+ "", nativeQuery=true)
	    List<String> findMonarchyCountries();
	    @Query(value="SELECT countries.region,COUNT(countries.id) AS NumberOfCountries  FROM countries GROUP BY countries.region ORDER BY NumberOfCountries DESC  ;\r\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> findRegionCountries();


}




