package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.model.Student;

@Controller
public class NormalController {

	@GetMapping("/")
	public String showHome(Model model) {
		
		model.addAttribute("newStudent", new Student());
		return "home-view";
	}
	
	@GetMapping("/form")
	public String showForm(Model model,
			@Validated @ModelAttribute("newStudent") Student student) {
		
		model.addAttribute("student", student);
		return "info-view";
	}
}
