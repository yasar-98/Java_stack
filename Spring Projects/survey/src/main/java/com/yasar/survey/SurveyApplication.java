package com.yasar.survey;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class SurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="name") String name, @RequestParam(value="location") String location,@RequestParam(value="laguage") String laguage, @RequestParam(value="comment") String comment,HttpSession session) {
          // ... process information and save it to the session
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("laguage", laguage);
        session.setAttribute("comment", comment);

          return "redirect:/survey";
    }
	
	@RequestMapping("/")
    public String index() {
		return "index.jsp";
	}

	@RequestMapping("/survey")
    public String survey(Model model,HttpSession session) {
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("location", session.getAttribute("location"));
        model.addAttribute("laguage", session.getAttribute("laguage"));
        model.addAttribute("comment", session.getAttribute("comment"));
        return "survey.jsp";
	}
}
