package com.asm.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.entity.Order;
import com.asm.entity.OrderItem;
import com.asm.entity.User;
import com.asm.exception.OrderNotFoundException;
import com.asm.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserService userService;

	@Override
	public Order saveOrder(int userId, List<OrderItem> orderItem) {

		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		orderItem.forEach(n -> {
			n.setOrder(order);
		});
		User user = userService.getUserById(userId);
		order.setUser(user);

		order.setOrderItems(orderItem);
		order.setOrderStatus("pending");

		Order placedOrder = orderRepository.save(order);
		return placedOrder;

	}

	@Override
	public Order getOrderById(int orderId) {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		Order orderById = optionalOrder.get();
		return orderById;
	}

	

	@Override
	public void cancelOrderById(int orderId) {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("Order not found with this Id :" + orderId);
		}
		
		orderRepository.deleteById(orderId);
		
	}

	@Override
	public List<Order> getAll() {
		
		List<Order> allOrder = orderRepository.findAll();
		return allOrder;
	}

}
