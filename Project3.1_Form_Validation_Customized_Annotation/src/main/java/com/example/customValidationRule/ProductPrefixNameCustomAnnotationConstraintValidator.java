package com.example.customValidationRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductPrefixNameCustomAnnotationConstraintValidator
		implements ConstraintValidator<ProductPrefixNameCustomAnnotation, String>{

	private String productPrefixName;
	
	public void initialize(ProductPrefixNameCustomAnnotation constraintAnnotation) {
		
		productPrefixName = constraintAnnotation.value();
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		if(value != null) {
			return value.startsWith(productPrefixName);
		} 
		
		return true;
	}
}

		
