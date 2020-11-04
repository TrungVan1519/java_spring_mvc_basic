package com.example.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ItemDTO;
import com.example.dto.OrderDTO;
import com.example.dto.ProductDTO;
import com.example.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/shopping-cart")
	public String showShoppingCart(Model model, HttpSession session) {
		
		// lay ra gio hang tu session
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("shoppingCart");
		
		// neu gio hang da ton tai
		if(orderDTO != null) {
			
			// truyen gio hang qua View
			model.addAttribute("order", orderDTO);
		}
		
		return "shoppingCart.definition";
	}
	
	@GetMapping("/adding-to-shopping-cart/{productId}")
	public String addToShoppingCart(Model model, HttpSession session,
			@PathVariable int productId) {
		
		// lay ra product da chon
		ProductDTO productDTO = productService.findById(productId);
		
		// lay ra gio hang tu session
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("shoppingCart");
		
		// neu gio hang da ton tai
		if(orderDTO != null) {
			
			// lay ra danh sach hang trong gio hang
			List<ItemDTO> itemDTOs = orderDTO.getItemDTOs();
			
			// kiem tra hang (tuong ung voi product da chon) co trong danh sach hang hay chua?
			// 		- neu co roi thi tang so luong hang (tuong ung voi product da chon) len +1
			//		- neu chua co thi tao moi 1 hang (tuong ung product da chon) roi them moi 
			//		vao danh sach hang
			boolean isExist = false;
			for(ItemDTO itemDTO : itemDTOs) {

				// 	- neu co roi thi tang so luong len +1
				if(itemDTO.getProductDTO().getId() == productDTO.getId()) {

					itemDTO.setNumberOfChosenProduct(itemDTO.getNumberOfChosenProduct() + 1);
					isExist = true;
				}
			}
			//	- neu chua co thi them moi vao danh sach hang
			if(!isExist) {
				
				// tao moi hang (tuong ung voi product da chon) va them vao danh sach hang
				//	vua tao
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setNumberOfChosenProduct(1);
				itemDTO.setProductDTO(productDTO);
				itemDTOs.add(itemDTO);
			}
		} else {
			
			// tao moi gio hang va them vao session
			orderDTO = new OrderDTO();
			session.setAttribute("shoppingCart", orderDTO);

			// tao moi danh sach hang va them vao gio hang vua tao
			List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
			orderDTO.setItemDTOs(itemDTOs);
			
			// tao moi hang (tuong ung voi product da chon) va them vao danh sach hang
			//	vua tao
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setNumberOfChosenProduct(1);
			itemDTO.setProductDTO(productDTO);
			itemDTOs.add(itemDTO);
		}
		return "redirect:/order/shopping-cart";
	}
	
	@GetMapping("/decreasing-quantity/{productId}")
	public String decreaseQuantity(Model model, HttpSession session,
			@PathVariable int productId) {

		// lay ra gio hang tu session
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("shoppingCart");
		
		// neu gio hang da ton tai
		if(orderDTO != null) {

			// lay ra danh sach hang trong gio hang
			List<ItemDTO> itemDTOs = orderDTO.getItemDTOs();
			
			// kiem tra hang (tuong ung voi product da chon) co trong danh sach hang hay chua?
			// 		- neu co roi thi giam so luong xuong -1
			//			+ neu so luong == 1 thi sau khi giam xuong -1 phai xoa khoi 
			//			danh sach hang
			//			+ neu luong > 1 thi chi can giam xuong -1 la xong
			for(ItemDTO itemDTO : itemDTOs) {

				// 	- neu co roi thi giam so luong xuong -1
				if(itemDTO.getProductDTO().getId() == productId) {
					
					// - neu so luong hang == 1 thi khi giam -1 = 0, phai xoa hang khoi
					//	danh sach hang
					if(itemDTO.getNumberOfChosenProduct() == 1) {
						
						itemDTOs.remove(itemDTO);
						break;
					}

					// - neu so luong > 1 thi chi don gian la giam so luong xuong -1
					itemDTO.setNumberOfChosenProduct(itemDTO.getNumberOfChosenProduct() - 1);
					break;
				}
			}
			
			// neu danh sach hang het hang thi xoa luon ca gio hang
			if(itemDTOs.isEmpty()) {
				
				session.removeAttribute("shoppingCart");
			}
		}
		
		return "redirect:/order/shopping-cart";
	}
	
	@GetMapping("/deleting-from-shopping-cart/{productId}")
	public String deleteFromShoppingCart(Model model, HttpSession session,
			@PathVariable int productId) {
		
		// lay ra gio hang tu session
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("shoppingCart");
		
		// neu gio hang da ton tai
		if(orderDTO != null) {

			// lay ra danh sach hang trong gio hang
			List<ItemDTO> itemDTOs = orderDTO.getItemDTOs();

			// kiem tra hang (tuong ung voi product da chon) co trong danh sach hang hay chua?
			// 		- neu co roi thi xoa luon hang khoi danh sach hang
			Iterator<ItemDTO> iterator = itemDTOs.iterator();
			while(iterator.hasNext()) {
				
				if(iterator.next().getProductDTO().getId() == productId) {
					
					iterator.remove();
				} 
			}
			
			// neu danh sach hang het hang thi xoa luon ca gio hang
			if(itemDTOs.isEmpty()) {
				
				session.removeAttribute("shoppingCart");
			}
		}
		
		return "redirect:/order/shopping-cart";
	}
}
