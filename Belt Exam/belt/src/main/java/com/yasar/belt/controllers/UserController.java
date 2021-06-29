package com.yasar.belt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yasar.belt.models.Event;
import com.yasar.belt.models.State;
import com.yasar.belt.models.User;
import com.yasar.belt.services.UserService;
import com.yasar.belt.validator.UserValidator;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/sign")
    public String registerForm(@ModelAttribute("user") User user, Model model) {
    	model.addAttribute("states", State.states);
        return "sign.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
        userValidator.validate(user, result);
    	if(result.hasErrors()) {
        	model.addAttribute("user", user);
        	model.addAttribute("states", State.states);
            return "sign.jsp";
    	}
    	User u =userService.registerUser(user);
        session.setAttribute("id", u.getId());
    	return "redirect:/event";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(final RedirectAttributes redirectAttributes,@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email,password)) {
        	User user = userService.findByEmail(email);
            session.setAttribute("id", user.getId());
        	return "redirect:/event";
    	}else {
    	    redirectAttributes.addFlashAttribute("error", "Invalid email or password, Please try again");
        	return "redirect:/sign";
    	}

    }
    
    @RequestMapping("/event")
    public String home(HttpSession session, Model model,@ModelAttribute("event") Event event) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("id");
    	User user= userService.findUserById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("states", State.states);
    	model.addAttribute("eventState",userService.findByState(user.getState()));
    	model.addAttribute("eventOther",userService.findByStateIsNot(user.getState()));
        return "event.jsp";
    }
    @PostMapping("/event")
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,HttpSession session, Model model) {
    	
        if (result.hasErrors()) {
        	Long id = (Long) session.getAttribute("id");
        	User user= userService.findUserById(id);
        	model.addAttribute("user", user);
        	model.addAttribute("states", State.states);
        	model.addAttribute("eventState",userService.findByState(user.getState()));
        	model.addAttribute("eventOther",userService.findByStateIsNot(user.getState()));
            return "event.jsp";
        } else {
        	userService.createEvent(event);
            return "redirect:/event";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/sign";
    }
	@GetMapping("/events/{id}/edit")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long idu = (Long) session.getAttribute("id");
    	User user= userService.findUserById(idu);
    	model.addAttribute("user", user);
		Event event = userService.findEventById(id);
		if(user == null)
			return "redirect:/sign";
		if(event == null || !event.getPlanner().getId().equals(user.getId()))
			return "redirect:/event";
		
		model.addAttribute("event", event);
		model.addAttribute("states", State.states);
		return "edit.jsp";
	}
	@PutMapping("/events/{id}/edit")
	public String Update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
	    	Long idu = (Long) session.getAttribute("id");
	    	User user= userService.findUserById(idu);
	    	model.addAttribute("user", user);
			model.addAttribute("states", State.states);
			return "edit.jsp";
		}
		userService.update(event);
		return "redirect:/event";
	}
	@DeleteMapping("/events/{id}/delete")
	public String Delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/event";
	}
	@GetMapping("/events/{id}/a/{choice}")
	public String ManageAttenders(@PathVariable("id") Long id, @PathVariable("choice") String choice, HttpSession session) {
    	Long idu = (Long) session.getAttribute("id");
    	User user= userService.findUserById(idu);
		Event event = userService.findEventById(id);
		boolean isJoining = (choice.equals("join"));
		if(user == null)
			return "redirect:/sign";
		
		userService.manageAttenders(event, user, isJoining);
		
		return "redirect:/event";
	}
	@GetMapping("/events/{id}")
	public String Show(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long idu = (Long) session.getAttribute("id");
    	User user= userService.findUserById(idu);
		Event event = userService.findEventById(id);
		if(user == null)
			return "redirect:/sign";
		if(event == null)
			return "redirect:/event";
		model.addAttribute("event", event);
		model.addAttribute("user", user);
		return "show.jsp";
	}
	@PostMapping("/events/{id}/comment")
	public String Comment(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes redirs, HttpSession session) {
    	Long idu = (Long) session.getAttribute("id");
    	User user= userService.findUserById(idu);
		if(user == null)
			return "redirect:/sign";
		if(comment.equals("")) {
			redirs.addFlashAttribute("error", "Comment must not be blank");
			return "redirect:/events/" + id ;
		}
		
		Event event = userService.findEventById(id);
		userService.comment(user, event, comment);
		return "redirect:/events/" + id;
	}

}
