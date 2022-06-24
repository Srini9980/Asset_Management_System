package com.asm.service;

import java.util.List;

import com.asm.entity.Order;
import com.asm.entity.OrderItem;

public interface OrderService {
	
	public Order saveOrder(int userId, List<OrderItem> orderItem);
	
	public Order getOrderById(int orderId);

	public List<Order> getAll();
	
	public void cancelOrderById(int orderId);
	
}
