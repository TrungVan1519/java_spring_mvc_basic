package com.example.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/loginController")
	public String login(Model model,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) boolean logout) {
		
		if(error != null) {
			
			logger.info(">> error: " + error);
			model.addAttribute("error", error);
		}
		
		if(logout) {
			
			model.addAttribute("logout", logout);
		}
		
		return "login-view";
	}
	
	@PostMapping("/logoutController")
	public String logout(RedirectAttributes redirectAttributes,
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			
			System.out.println("Username: " + authentication.getName() + " had been logout");
			new SecurityContextLogoutHandler().logout(request, response, authentication);
			redirectAttributes.addAttribute("logout", true);
		}
		
		return "redirect:/login/loginController";
	}
}
