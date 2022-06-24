package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.OrderItem;
import com.asm.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
//	@PostMapping("/orderItem/save")
//	public ResponseEntity<OrderItem> addOrderItem(@Valid @RequestBody OrderItem orderItem) {
//		
//		OrderItem newOrderItem = orderItemService.addOrderItem(orderItem);		
//		ResponseEntity<OrderItem> responseEntity = new ResponseEntity<>(newOrderItem,HttpStatus.CREATED);
//		return responseEntity;
//	}
	@GetMapping("/orderItem/find/{orderItemId}")
	public ResponseEntity<Object> fetchOrderItemById(@PathVariable("orderItemId") int orderItemId) {
		
		ResponseEntity<Object> responseEntity = null;		
		OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);	
		responseEntity = new ResponseEntity<>(orderItem,HttpStatus.OK);				
		return responseEntity;
	}
	/*@DeleteMapping("/orderItem/delete/{orderItemId}")
	public ResponseEntity<String> removeOrderItem(@PathVariable("orderItemId") int orderItemId) {
		
		orderItemService.deleteOrderItemById(orderItemId);		
		ResponseEntity<String> responseEntity = new ResponseEntity<>("orderItem Deleted Successfully.", HttpStatus.OK);
		return responseEntity;		
	}*/
	
	@GetMapping("/orderItem/all")
     public List<OrderItem> fetchAllOrders() {
		
		List<OrderItem> allOrderItem = orderItemService.getAllOrderItem();
		return allOrderItem;

	} 
	
	/*@PutMapping("/orderItem/update")
	public ResponseEntity<OrderItem> modifyProduct(@RequestBody OrderItem orderItem) {
		
		OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);	
		ResponseEntity<OrderItem> responseEntity = new ResponseEntity<>(updatedOrderItem,HttpStatus.OK);
		return responseEntity;
	}	*/

}
