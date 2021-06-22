package com.yasar.language.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yasar.language.models.Language;
import com.yasar.language.repositories.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage( Language b) {
        return languageRepository.save(b);   
        
    }
    // update language

    public Language updateLanguage(@Valid Language languages) {
		  Language lanuages =findLanguage(languages.getId());
		  lanuages.setName(languages.getName());
		  lanuages.setCreator(languages.getCreator());
		  lanuages.setVersion(languages.getVersion());
			
			 return languageRepository.save(lanuages);
		}

    //delete language
    public void deleteLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
        	languageRepository.deleteById(id);
        }
    }


    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

}
