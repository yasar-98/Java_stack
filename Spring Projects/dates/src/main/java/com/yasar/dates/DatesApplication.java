package com.yasar.dates;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootApplication
@Controller
public class DatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatesApplication.class, args);
	}
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
	}
	@RequestMapping("/date")
    public String date(Model model) {
		java.util.Date date=new java.util.Date();  
        model.addAttribute("date", date);
        return "date.jsp";
	}
	@RequestMapping("/time")
    public String time(Model model) {
		model.addAttribute("time", LocalTime.now());
        return "time.jsp";
	}
}
