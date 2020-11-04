package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.ProductDTO;
import com.example.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Create
	@GetMapping("/adding-form")
	public String showAddingForm(Model model) {
		
		model.addAttribute("newProduct", new ProductDTO());
		return "adding-form-view";
	}
	
	@PostMapping("/adding-form")
	public String addProduct(Model model,
			@Valid @ModelAttribute("newProduct") ProductDTO product,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {

			System.out.println(bindingResult.getAllErrors().toString());
			return "adding-form-view";
		}
		
		// add new product to DB
		productService.add(product);
		return "redirect:/products";
	}
	
	// Retrieve
	@GetMapping("/products")
	public String getProductList(Model model) {
		
		model.addAttribute("products", productService.findAll());
		return "list-view";
	}
	
	@GetMapping("/products/{productId}")
	public String getSingleProduct(Model model, @PathVariable int productId) {
		
		model.addAttribute("selectedProduct", productService.findById(productId));
		return "single-view";
	}
	
	// Update
	@GetMapping("/updating-form/{productId}")
	public String showUpdatingForm(Model model, @PathVariable int productId) {
		
		model.addAttribute("selectedProduct", productService.findById(productId));
		return "updating-form-view";
	}
	
	@PostMapping("/updating-form")
	public String updateProduct(Model model, 
			@Valid @ModelAttribute("selectedProduct") ProductDTO product,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getAllErrors().toString());
			return "updating-form-view";
		}
		
		// update selected product
		productService.update(product);
		return "redirect:/products";
	}
	
	// Delete
	@GetMapping("/deleting-product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		// delete selected product from DB
		productService.deleteById(productId);
		return "redirect:/products";
	}
}
