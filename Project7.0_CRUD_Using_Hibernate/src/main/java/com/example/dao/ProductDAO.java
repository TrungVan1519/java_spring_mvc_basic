package com.example.dao;

import java.util.List;

import com.example.entity.ProductEntity;

public interface ProductDAO {
	
	void add(ProductEntity productEntity);
	
	void update(ProductEntity productEntity);
	
	void deleteById(int id);
	
	ProductEntity findById(int id);
	
	List<ProductEntity> findAll();
}
