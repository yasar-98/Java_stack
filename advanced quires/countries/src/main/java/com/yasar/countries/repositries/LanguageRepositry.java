package com.yasar.countries.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.countries.models.Language;

@Repository
public interface LanguageRepositry extends CrudRepository<Language, Long>{
	   @Query(value="SELECT countries.name,languages.language,languages.percentage FROM countries JOIN languages ON countries.id= languages.country_id where languages.percentage > '89.0' ORDER BY languages.percentage DESC;\r\n"
	    		+ "", nativeQuery=true)
	    List<Object[]> findAlllanguagePer89();
	
}
