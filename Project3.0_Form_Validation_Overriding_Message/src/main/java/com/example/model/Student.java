package com.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private int id;
	
	@NotEmpty
	@Size(min = 3, message = "fullname has to include 3 chars at least")
	private String fullName;

	@NotNull
	@Min(value = 10)
	@Max(value = 20)
	private Integer age;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^[a-zA-Z0-5]{3}$", message = "username has to include only 3 chars or 3 digits")
	private String username;

	@Length(min = 1, max = 3, message = "password has to include 1-3 chars")
	private String password;
}


