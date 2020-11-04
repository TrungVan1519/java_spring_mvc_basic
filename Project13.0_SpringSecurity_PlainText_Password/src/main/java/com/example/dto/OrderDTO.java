package com.example.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {

	private List<ItemDTO> itemDTOs;
}
