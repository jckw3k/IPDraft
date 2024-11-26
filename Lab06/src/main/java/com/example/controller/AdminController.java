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

public class AdminController {
	
	
	 @GetMapping("/clientList")
	 public ModelAndView showClientList() {
	 ModelAndView modelAndView = new ModelAndView("clientList");
	 modelAndView.addObject("message", "Welcome to the ClientList Page!");
	 modelAndView.addObject("clients", ClientController.clientList);
	 return modelAndView;
	 } 
	 
}