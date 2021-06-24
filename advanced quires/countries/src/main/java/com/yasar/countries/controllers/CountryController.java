package com.yasar.countries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasar.countries.models.Language;
import com.yasar.countries.services.CountryService;

@RestController
public class CountryController {
    private final CountryService countryService;
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }
    @RequestMapping("/api/country/Slovene")
    public List<Object[]> sloveneCountry() {
        return countryService.findAllCountriesWithLanguageSlovene();
    }
    @RequestMapping("/api/country/numCity")
    public List<Object[]> numCityCountry() {
        return countryService.findAllCountriesWithNumofCity();
    }
    @RequestMapping("/api/maxico/city/pop")
    public List<Object[]> findAllMaxicoCityPop() {
        return countryService.findAllMaxicoCityPop();
    }
    @RequestMapping("/api/language/per89")
    public List<Object[]> findAlllanguagePer89() {
        return countryService.findAlllanguagePer89();
    }
    @RequestMapping("/api/country/SA501/POP100000")
    public List<String> findSpecefiedCountries() {
        return countryService.findSpecefiedCountries();
    }
    @RequestMapping("/api/country/Monarchy")
    public List<String> findMonarchyCountries() {
        return countryService.findMonarchyCountries();
    }
    @RequestMapping("/api/city/Argentina")
    public List<Object[]> findSpecificCities() {
        return countryService.findSpecificCities();
    }
    @RequestMapping("/api/country/region")
    public List<Object[]> findRegionCountries() {
        return countryService.findRegionCountries();
    }

}
