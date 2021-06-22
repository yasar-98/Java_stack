package com.yasar.ninja;

import java.text.SimpleDateFormat;

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
public class NinjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaApplication.class, args);
	}
	 @RequestMapping("/gold")
	public String dashboard(HttpSession session,Model model) {
		 	if(session.isNew()) {
				session.setAttribute("count",0);
		        session.setAttribute("message", "");
			}	
	        model.addAttribute("ninja", session.getAttribute("count"));
	        model.addAttribute("area", session.getAttribute("message"));
	        // ... any code to process before rendering
	        return "gold.jsp";
	    }
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
    public String login(@RequestParam(value="which_form") String user,HttpSession session) {
          // ... process information and save it to the session
		java.util.Date time = new java.util.Date();
		SimpleDateFormat formater = new SimpleDateFormat("MMMM dd yyyy, hh:mm:ss a");
		if(user.equals("register1")) {
			session.setAttribute("count",(int)session.getAttribute("count")+(int)(Math.random()*(20-10+1)+10));
	        session.setAttribute("message", session.getAttribute("message") + "farm (earns 10_20 golds)" + formater.format(time) + "\n");
		}
		if(user.equals("register2")) {
			session.setAttribute("count",(int)session.getAttribute("count")+(int)(Math.random()*(10-5+1)+5));
	        session.setAttribute("message", session.getAttribute("message") +  "cave (earns 5_10 golds)" + formater.format(time) + "\n");
		}
		if(user.equals("register3")) {
			session.setAttribute("count",(int)session.getAttribute("count")+(int)(Math.random()*(5-2+1)+2));
	        session.setAttribute("message", session.getAttribute("message") +  "house (earns 2_5 golds)" + formater.format(time) + "\n");
		}
		if(user.equals("register4")) {
			int max=50;
			int min=-50;
			session.setAttribute("count",(int)session.getAttribute("count")+(int)(Math.random()*(max-min+1)+min));
	        session.setAttribute("message", session.getAttribute("message") +  "casisno (earns/takes 0_50 golds)" + formater.format(time) + "\n");
		}
        
		return "redirect:/gold";
    }
}
