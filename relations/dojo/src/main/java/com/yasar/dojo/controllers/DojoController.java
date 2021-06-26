package com.yasar.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.dojo.models.Dojo;
import com.yasar.dojo.models.Ninja;
import com.yasar.dojo.services.DojoService;
import com.yasar.dojo.services.NinjaService;

@Controller
public class DojoController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
	
	@RequestMapping("/dojo/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newdojo.jsp";
    }
    @RequestMapping(value="/dojo/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newdojo.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/dojo/new";
        }
    }
	@RequestMapping("/dojo/{id}")
    public String newNinja(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = ninjaService.allNinjasdojo(id);
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojo", dojo);
        return "dojoInfo.jsp";
    }
}
