package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;

@Controller
@RequestMapping("/request-param")
public class RequestParamController {

	@GetMapping("/form")
	public String showForm(Model model) {
		
		return "adding-form-view";
	}
	
	@PostMapping("/product")
	public String addingProduct(Model model, 
			@RequestParam(required = true, defaultValue = "dau xanh") String name,
			@RequestParam(name = "cost") int productCost) {
		
		Product product = new Product(name, productCost);
		model.addAttribute("product", product);
		
		System.out.println(">> RequestParam:" + product);
		
		return "info-view";
	}
}



