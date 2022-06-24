package com.asm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.Order;
import com.asm.entity.OrderItem;
import com.asm.model.OrderAssetQuantity;
import com.asm.model.OrderRequest;
import com.asm.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	ResponseEntity<Object> responseEntity = null;

	@PostMapping("/order/save")
	public ResponseEntity<Object> makeOrder(@Valid @RequestBody OrderRequest orderRequest) {

		List<OrderAssetQuantity> orderQuantity = orderRequest.getOrderAssetQuantity();
		int userId = orderRequest.getUserId();

		List<OrderItem> orderItems = new ArrayList<>();

		orderQuantity.forEach(r -> {
			OrderItem orderItem = new OrderItem();
			orderItem.setAssetId(r.getAssetId());
			orderItem.setItemQuantity(r.getAssetQuantity());
			orderItems.add(orderItem);
		});

		Order newOrder = orderService.saveOrder(userId, orderItems);

		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}

	@GetMapping("/order/getById/{oId}")
	public ResponseEntity<Object> searchById(@PathVariable("oId") int orderId) {
		Order order = orderService.getOrderById(orderId);
		responseEntity = new ResponseEntity<>(order, HttpStatus.FOUND);
		return responseEntity;

	}

	@GetMapping("/order/getAll")
	public List<Order> getAllOrders() {
		
		List<Order> allOrder = orderService.getAll();
		return allOrder;

	}

	@DeleteMapping("/order/cancel/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable("orderId") int orderId) {
		
		orderService.cancelOrderById(orderId);
		return new ResponseEntity<>("Order Successfully Cancelled", HttpStatus.GONE);
	}

}
