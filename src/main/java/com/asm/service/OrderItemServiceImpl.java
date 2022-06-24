package com.asm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.entity.OrderItem;
import com.asm.exception.OrderItemNotFoundException;
import com.asm.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	/*@Override
	public OrderItem addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
			
			OrderItem saveOrderItem = orderItemRepository.save(orderItem);
			return saveOrderItem;
		
		
	}*/

	@Override
	public OrderItem getOrderItemById(int orderItemId) {

		Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);

		if (optionalOrderItem.isEmpty()) {
            throw new OrderItemNotFoundException("OrderItem Not found with id: " + orderItemId);
		}

		OrderItem orderItem = optionalOrderItem.get();
		return orderItem;
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		
		List<OrderItem> orderItems = orderItemRepository.findAll();
		return orderItems;
	}

	/*@Override
	public void deleteOrderItemById(int orderItemId) {
		
		Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
		if(optionalOrderItem.isEmpty()) {
			throw new OrderItemNotFoundException("OrderItem Not found with id: "+orderItemId);
		}
		
		orderItemRepository.deleteById(orderItemId);		
		
	}*/
}
