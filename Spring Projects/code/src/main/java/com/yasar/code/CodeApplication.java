package com.yasar.code;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeApplication.class, args);
	}
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="code") String code,RedirectAttributes redirectAttributes) {
    	if(code.equals("bushido")) {
            return "redirect:/code";
    	}else {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
    	}
    }
    private String[] getbush() {
		return new String[] {
			"Loyalty", "Courage", "Veracity", "Compassion", "Honor"
		};
	}
	@RequestMapping("/")
    public String index() {
		return "index.jsp";
	}

	@RequestMapping("/code")
    public String code(Model model) {
		model.addAttribute("bush", getbush());
        return "code.jsp";
	}

}
