package com.example.service; 

import java.util.List;

import com.example.dto.ProductDTO;

public interface ProductService {

	void add(ProductDTO productDTO);
	
	void update(ProductDTO productDTO);
	
	void deleteById(int id);
	
	ProductDTO findById(int id);
	
	List<ProductDTO> findAll();
}
