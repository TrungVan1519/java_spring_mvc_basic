package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Product;

@Controller
@RequestMapping("/path-variable")
public class PathVariableController {

	@GetMapping("/link")
	public String showForm(Model model) {
		
		model.addAttribute("defaultProduct", new Product("default name", -1));
		
		return "adding-link-view";
	}
	
	@GetMapping("/product/{name}/{cost}")
	public String addingProduct(Model model, 
			@PathVariable(required = true) String name,
			@PathVariable(name = "cost") int defaultCost) {
		
		Product product = new Product(name, defaultCost);
		model.addAttribute("product", product);
		
		System.out.println(">> PathVaiable:" + product);
		
		return "info-view";
	}
}



