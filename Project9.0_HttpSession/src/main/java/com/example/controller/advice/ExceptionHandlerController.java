package com.example.controller.advice;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController {

	@ExceptionHandler(value = { NoHandlerFoundException.class })
	public String handleNotFoundException() {

		return "==> Not Found Exception Handler";
	}

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException() {

		return "==> Null Pointer Exception";
	}
	
	@ExceptionHandler(BindException.class)
	public String handleBindException(Model model, BindException exception) {

		StringBuilder error = new StringBuilder();
		for (ObjectError objectError : exception.getAllErrors()) {
			
			error.append(objectError.getDefaultMessage() + "\n");
//			error.append("<br/>");
		}
		
		model.addAttribute("error", error);
		return "==> Bind Exception Handler: \n" + error;
	}

	@ExceptionHandler(Exception.class)
	public String handleException() {

		return "==> All Other Exception Else";
	}
}
