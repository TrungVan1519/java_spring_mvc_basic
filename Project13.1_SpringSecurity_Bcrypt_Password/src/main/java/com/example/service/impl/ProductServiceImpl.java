package com.example.service.impl;  

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ProductDAO;
import com.example.dto.ProductDTO;
import com.example.entity.ProductEntity;
import com.example.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;

	public void add(ProductDTO productDTO) {
		
		ProductEntity studentEntity = new ProductEntity(productDTO.getFullName(),
														productDTO.getCost());
		productDAO.add(studentEntity);
	}

	public void update(ProductDTO productDTO) {
		
		ProductEntity productEntity = productDAO.findById(productDTO.getId());
		if(productEntity != null) {
			
			productEntity.setFullName(productDTO.getFullName());
			productEntity.setCost(productDTO.getCost());
			
			productDAO.update(productEntity);
		}
	}

	public void deleteById(int id) {
		
		ProductEntity productEntity = productDAO.findById(id);
		if(productEntity != null) {
			
			productDAO.deleteById(id);
		}
	}

	public ProductDTO findById(int id) {
		
		ProductEntity productEntity = productDAO.findById(id);
		ProductDTO productDTO = new ProductDTO(productEntity.getFullName(), 
											   productEntity.getCost());
		productDTO.setId(productEntity.getId());
		
		return productDTO;
	}

	public List<ProductDTO> findAll() {
		
		List<ProductEntity> productEntities = productDAO.findAll();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(ProductEntity productEntity: productEntities) {
			
			ProductDTO studentDTO = new ProductDTO(productEntity.getFullName(), 
					  							   productEntity.getCost());
			studentDTO.setId(productEntity.getId());
			
			// add to List<StudentDTO>
			productDTOs.add(studentDTO);
		}
		
		return productDTOs;
	}
}
