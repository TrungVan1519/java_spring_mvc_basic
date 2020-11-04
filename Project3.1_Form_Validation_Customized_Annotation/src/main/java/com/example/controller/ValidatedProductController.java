package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Product;

@Controller
@RequestMapping("/custom-validation")
public class ValidatedProductController {

	private List<Product> products;
	
	@PostConstruct	
	private void setupData() {
		products = new ArrayList<Product>();
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		
		// add and initBinder to convert trum input string
		// remove leading and trailing whitespace
		// resolve issue for our validation
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	// Create
	@GetMapping("/adding-form")
	public String showAddingForm(Model model) {
		
		// > Vi:
		//	+ Day chi la VD cho @ModelAttibute vs Spring Form Tags
		// 		nen o day su dung List<Product> de them thay vi su dung DB
		//	+ Prop Id cua Product khong duoc phep nhap du lieu tu Form,
		//		no phai tu dong co truoc
		// > Cung vi ly do tren ma Product khong co id truoc nen phai
		//		setId() bang tay thu cong <=> AUTO_INCREASWMENT
		Product product = new Product();
		product.setId(products.size());
		model.addAttribute("newProduct", product);
		
		return "custom-validation-view/adding-form-view";
	}
	
	@PostMapping("/adding-form")
	public String addProduct(Model model, 
			@Valid @ModelAttribute("newProduct") Product product,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			// print the error to override message error if needed
			System.out.println(">> bindingResult: " + bindingResult);
			return "custom-validation-view/adding-form-view";
		}
		
		products.add(product);
		return "redirect:/custom-validation/products";
	}

	// Retrieve list
	@GetMapping("/products")
	public String getProductList(Model model) {

		model.addAttribute("products", products);
		return "custom-validation-view/product-list-view";
	}
}
