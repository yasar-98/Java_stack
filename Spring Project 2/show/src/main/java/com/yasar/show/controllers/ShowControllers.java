package com.yasar.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yasar.show.models.Book;
import com.yasar.show.service.BookService;

@Controller
public class ShowControllers {
	
	    private final BookService bookService;
	    
	    public ShowControllers(BookService bookService) {
	        this.bookService = bookService;
	    }
	    

	    @RequestMapping("/books/{id}")
	    public String lang(Model model,@PathVariable("id") Long id) {
	    	Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "show.jsp";
	    }
}
