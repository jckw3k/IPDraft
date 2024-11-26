package com.example.controller;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Client; 
@Controller
@RequestMapping("/") 

public class ClientController {
	
	public static List<Client> clientList = new ArrayList<>();
	
	 @GetMapping("/register")
	 public ModelAndView showRegisterForm() {
	 ModelAndView modelAndView = new ModelAndView("register");
	 modelAndView.addObject("message", "Welcome to the Register Page!");
	 return modelAndView;
	 } 
	 
	 @GetMapping("/login")
	 public ModelAndView showLoginForm() {
	 ModelAndView modelAndView = new ModelAndView("login");
	 modelAndView.addObject("message", "Welcome to the Login Page!");
	 return modelAndView;
	 } 
	 
	 @PostMapping("/login")
	 public String processLoginForm(
	            @RequestParam("username") String username,
	            @RequestParam("password") String password,
	            Model model) {

	        // Validate credentials
		   for (Client client : clientList) {
		        if (client.getUsername().equals(username) && client.getPassword().equals(password)) {
		            model.addAttribute("message", "Login successful! Welcome, " + username + "!");
		            return "profile"; // Redirect to profile.jsp
		        }
		    }
	            model.addAttribute("message", "Invalid credentials. Please try again.");
	            return "login"; // Stay on login.jsp with error message
	}
	 
	 
	 @PostMapping("/register")
	 public String processRegisterForm(
	            @RequestParam("username") String username,
	            @RequestParam("password") String password,
	            Model model) {

	     // Simple validation
	     if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	         model.addAttribute("message", "Error: All fields are required!");
	         return "register"; // Stay on the registration page with an error message
	     }

	     // Assume registration success
	     Client c = new Client(username,password);
	     clientList.add(c);
	     model.addAttribute("message", "Registration successful! Please log in.");
	     return "redirect:/login"; // Redirect to login page after successful registration
	}
	 
	 
	    
	 @GetMapping("/profile")
	 public ModelAndView showProfile() {
	 ModelAndView modelAndView = new ModelAndView("profile");
	 modelAndView.addObject("message", "Welcome to the Profile Page!");
	 return modelAndView;
	 } 
}