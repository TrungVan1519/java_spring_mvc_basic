package com.example.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private int id;
	
	@NotEmpty
	private String fullName;

	@Min(0)
	private Integer cost;

	public ProductDTO(@NotEmpty String fullName, @Min(0) Integer cost) {
		this.fullName = fullName;
		this.cost = cost;
	}
}
