package com.yasar.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.dojo.models.Dojo;
import com.yasar.dojo.models.Ninja;
import com.yasar.dojo.services.DojoService;
import com.yasar.dojo.services.NinjaService;


@Controller
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

	@RequestMapping("/ninja/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newninja.jsp";
    }
    @RequestMapping(value="/ninja/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newninja.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninja/new";
        }
    }
}
