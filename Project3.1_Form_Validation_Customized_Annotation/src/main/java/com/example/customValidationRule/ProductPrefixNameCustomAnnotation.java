package com.example.customValidationRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ProductPrefixNameCustomAnnotationConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductPrefixNameCustomAnnotation {
	
	// default value
	public String value() default "CustomValidationRule_";
	
	// default error message
	public String message() default "must start with CustomValidationRule_";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	// define extends payloads
	// payloads: provide custom details about validation failure
	//			(severity level, error code, etc)
	public Class<? extends Payload>[] payload() default {};
}
