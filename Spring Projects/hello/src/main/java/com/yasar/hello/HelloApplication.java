package com.yasar.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	@RequestMapping("/")
    public String index(Model model,@RequestParam(value="name", required=false) String searchQuery) {
        if (searchQuery==null) {
        	model.addAttribute("human", "human");
        }else {
        	model.addAttribute("human", searchQuery);
        }
		return "index.jsp";
	}
}
