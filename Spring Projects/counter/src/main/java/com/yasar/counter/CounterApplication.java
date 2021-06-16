package com.yasar.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	public int getCount(HttpSession session) {
		Object count = session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", 0);
			count = session.getAttribute("count");
		}
		return (int) count;
	}
	public void setCount(HttpSession session, int val) {
		session.setAttribute("count", val);
	}
	@RequestMapping("/")
    public String index(HttpSession session) {
		int x =getCount(session);
		setCount(session, ++x);
		return "index.jsp";
	}

	@RequestMapping("/counter")
    public String counter(Model model, HttpSession session) {
	    model.addAttribute("count", getCount(session));
        return "counter.jsp";
	}
	@RequestMapping("/reset")
    public String reset(HttpSession session) {
		session.invalidate();
        return "redirect:/counter";
	}
	
}
