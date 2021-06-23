package com.yasar.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.license.models.License;
import com.yasar.license.models.Person;
import com.yasar.license.services.LicenseService;
import com.yasar.license.services.PersonService;

@Controller
public class LicenseController {
    // other methods removed for brevity
    private final LicenseService licenseService;
    private final PersonService personService;
    public LicenseController(LicenseService licenseService, PersonService personService){
        this.licenseService = licenseService;
        this.personService = personService;
    }
    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
    	List<Person> persons=personService.personsWithoutLicense();
    	model.addAttribute("persons", persons);
        return "license.jsp";
    }
    @RequestMapping(value="/licenses", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Person> persons=personService.personsWithoutLicense();
        	model.addAttribute("persons", persons);
            return "license.jsp";
        } else {
        	licenseService.createLicenseNumber(license);
        	licenseService.createLicense(license);
            return "redirect:/licenses/new";
        }
    }
}