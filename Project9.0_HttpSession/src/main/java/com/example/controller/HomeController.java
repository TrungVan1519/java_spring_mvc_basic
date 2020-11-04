package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
 
    @GetMapping(value = {"/", "/home"})
    public String homePage(HttpServletRequest request) {
    	
        return "homeView.definition";
    }
 
     
    @GetMapping("contact-us")
    public String contactusPage(Model model, HttpServletRequest request) {
    	
        model.addAttribute("address", "Vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        
        return "contactusView.definition";
    }
}