package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class NormalController {
	
	private Logger logger = Logger.getLogger(NormalController.class);
	
	@GetMapping("/testing-logger/{text}")
	public String getLogger(@PathVariable String text) throws Exception {
		
		logger.info(">> Input text: " + text);
		
		if(text.contains("exception")) {
			
			throw new Exception("Test thu loi de logger con ghi log vao file");
		}
		
		return text;
	}
}
