package com.asm.service;

import java.util.List;

import com.asm.entity.OrderItem;

public interface OrderItemService {

	public OrderItem getOrderItemById(int orderItemId);
	
//	public OrderItem addOrderItem(OrderItem orderItem);

	public List<OrderItem> getAllOrderItem();
	
//	public void deleteOrderItemById(int orderItemId);


}
