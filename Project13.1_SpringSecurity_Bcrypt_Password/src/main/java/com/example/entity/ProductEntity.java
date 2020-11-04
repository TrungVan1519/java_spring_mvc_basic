package com.example.entity; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotEmpty
	@Column(name = "full_name")
	private String fullName;

	@Min(0)
	@Column(name = "cost")
	private Integer cost;

	public ProductEntity(@NotEmpty String fullName, @Min(0) Integer cost) {
		this.fullName = fullName;
		this.cost = cost;
	}
}
