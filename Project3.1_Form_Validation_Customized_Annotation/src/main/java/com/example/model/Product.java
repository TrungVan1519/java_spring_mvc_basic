package com.example.model;

import javax.validation.constraints.NotEmpty;

import com.example.customValidationRule.ProductPrefixNameCustomAnnotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private int id;
	
	@NotEmpty
	@ProductPrefixNameCustomAnnotation
	private String firstName;

	@NotEmpty
	@ProductPrefixNameCustomAnnotation(value = "DauMa_",
			message = "lastname has to include DauMa_ at prefix")
	private String lastName;
}
