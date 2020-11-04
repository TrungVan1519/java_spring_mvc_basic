package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product;

@Controller
@RequestMapping("manual-form")
public class ManualFormController {
	
	private List<Product> products;
	
	@PostConstruct
	private void setupData() {
		products = new ArrayList<Product>();
		products.add(new Product(0, "dau xanh", 0));
		products.add(new Product(1, "rau muong", 1));
		products.add(new Product(2, "khoai san", 2));
	}

	// Create
	@GetMapping("/adding-form")
	public String showAddingForm(Model model) {
		
		// <=> AUTO_INCREASEMENT
		int productId = products.size();
		model.addAttribute("productId", productId);
		
		return "manual-form-view/adding-form-view";
	}
	
	@PostMapping("/adding-form")
	public String addingProduct(Model model,
			@RequestParam("id") int productId,
			@RequestParam("name") String productName,
			@RequestParam("cost") int productCost) {
		
		products.add(new Product(productId, productName, productCost));
		return "redirect:/manual-form/products";
	}
	
	// Retrieve
	@GetMapping("/products")
	public String getProductList(Model model) {
		
		model.addAttribute("products", products);
		return "manual-form-view/product-list-view";
	}
	
	@GetMapping("/products/{productId}")
	public String getSingleProduct(Model model,
			@PathVariable int productId) {
		
		model.addAttribute("selectedProduct", products.get(productId));
		return "manual-form-view/single-product-view";
	}
	
	// Update
	@GetMapping("/updating-form/{productId}")
	public String showUpdatingForm(Model model,
			@PathVariable int productId) {
		
		model.addAttribute("productId", productId);
		return "manual-form-view/updating-form-view";
	}
	
	@PostMapping("/updating-form/{productId}")
	public String updateProduct(Model model,
			@PathVariable int productId, // > co the su dung @RequestParam String id cung duoc
			@RequestParam String name,
			@RequestParam int cost) {
	
		// get existing product from products
		Product product = products.get(productId);
		
		// update the product
		product.setId(productId);
		product.setName(name);
		product.setCost(cost);
		
		return "redirect:/manual-form/products";
	}
	
	// Delete
	@GetMapping("/deleting-product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		products.remove(productId);
		
		for(Product product: products) {
			
			product.setId(products.indexOf(product));
		}
		
		return "redirect:/manual-form/products";
	}
}





