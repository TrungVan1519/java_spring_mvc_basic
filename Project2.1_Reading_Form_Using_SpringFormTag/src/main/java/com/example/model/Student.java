package com.example.model;

import java.util.List;

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
	
	private String username;
	private String password;

	private String gender;
	
	private String country;
	
	private List<String> programmingLanguage;
	
	private String about;
	private boolean acceptAgreement;
}


