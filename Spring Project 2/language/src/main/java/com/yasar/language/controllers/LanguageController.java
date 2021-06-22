package com.yasar.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.language.models.Language;
import com.yasar.language.services.LanguageService;

@Controller
public class LanguageController {
	 private final LanguageService languageService;

		
		public LanguageController(LanguageService languageService){
	        this.languageService = languageService;
	    }
//		@RequestMapping("/languages/new")
//	    public String newLanguage(@ModelAttribute("language") Language language) {
//			return "redirect:/languages";
//	    }
		@RequestMapping("/languages")
	    public String index(Model model) {
	        List<Language> languages = languageService.allLanguages();
	        model.addAttribute("language", languages);
	        Language language2 = new Language();
	        model.addAttribute("language2", language2);
	        return "languages.jsp";
	    }
		@RequestMapping("/languages/{id}")
	    public String lang(Model model,@PathVariable("id") Long id) {
			Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "lang.jsp";
	    }
//		@RequestMapping("/new")
//	    public String newLanguage(@ModelAttribute("language") Language language) {
//	        return "new.jsp";
//	    }
	    @RequestMapping(value="/languages", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("language2") Language language1, BindingResult result) {
	        if (result.hasErrors()) {
		        return "languages.jsp";
	        }else {
	        	languageService.createLanguage(language1);
		        return "redirect:/languages";

	        }
	
	    }
	    @RequestMapping("/languages/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	    	Language language = languageService.findLanguage(id);
	        model.addAttribute("edlanguage", language);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("edlanguage") Language language1, BindingResult result1,@PathVariable("id") Long id) {
	    	System.out.println("im in asdasdasd");
	        if (result1.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	languageService.updateLanguage(language1);
	            return "redirect:/languages";
	        }
	    }
	    @RequestMapping(value="/languages/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	    	languageService.deleteLanguage(id);
            return "redirect:/languages";

	    }
}
