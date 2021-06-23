package com.yasar.license.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.license.models.License;
import com.yasar.license.models.Person;
import com.yasar.license.services.LicenseService;
import com.yasar.license.services.PersonService;

@Controller
public class PersonController {
    // other methods removed for brevity
    private final PersonService personService;
    private final LicenseService licenseService;
    public PersonController(PersonService personService,LicenseService licenseService){
        this.personService = personService;
        this.licenseService = licenseService;
    }
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "person.jsp";
    }
    @RequestMapping(value="/persons", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "person.jsp";
        } else {
        	personService.createPerson(person);
            return "redirect:/persons/new";
         
        }
    }
    @RequestMapping("/person/{id}")
    public String concat(@PathVariable("id") Long id, Model model) {
    	License  license = licenseService.findLicense(id);
    	Person person = personService.findPerson(id);
    	model.addAttribute("license", license);
    	model.addAttribute("person", person);
        return "concat.jsp";
    }

    
}