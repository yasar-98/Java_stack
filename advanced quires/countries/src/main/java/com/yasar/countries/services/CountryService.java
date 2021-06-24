package com.yasar.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yasar.countries.repositries.CityRepositry;
import com.yasar.countries.repositries.CountryRepositry;
import com.yasar.countries.repositries.LanguageRepositry;

@Service
public class CountryService {
    private final CountryRepositry countryRepositry;
    private final CityRepositry cityRepositry;
    private final LanguageRepositry languageRepositry;
    public CountryService(CountryRepositry countryRepositry, CityRepositry cityRepositry, LanguageRepositry languageRepositry) {
        this.countryRepositry = countryRepositry;
        this.cityRepositry = cityRepositry;
        this.languageRepositry = languageRepositry;
    }
    public List<Object[]> findAllCountriesWithLanguageSlovene() {
        return countryRepositry.findAllCountriesWithLanguageSlovene();
    }
    public List<Object[]> findAllCountriesWithNumofCity() {
        return countryRepositry.findAllCountriesWithNumofCity();
    }
    public List<Object[]> findAllMaxicoCityPop() {
        return cityRepositry.findAllMaxicoCityPop();
    }
    public List<Object[]> findAlllanguagePer89() {
        return languageRepositry.findAlllanguagePer89();
    }
    public List<String> findSpecefiedCountries() {
        return countryRepositry.findSpecefiedCountries();
    }
    public List<String> findMonarchyCountries() {
        return countryRepositry.findMonarchyCountries();
    }
    public List<Object[]> findSpecificCities() {
        return cityRepositry.findSpecificCities();
    }
    public List<Object[]> findRegionCountries() {
        return countryRepositry.findRegionCountries();
    }


}
