package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.model.Product;

@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product product = (Product) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Custom.NotEmpty");
		
		if(!StringUtils.isEmpty(product.getName())) {
			
			if(product.getCost() == null) {
				
				errors.rejectValue("cost", "Custom.NotEmpty");
			} else {
				
				if(product.getCost() > 1000) {
					
					errors.rejectValue("cost", "Custom.MaxInteger.cost");
				} else if(product.getCost() < 0) {

					errors.rejectValue("cost", "Custom.MinInteger.cost");
				}
			}
		}
	}

}
