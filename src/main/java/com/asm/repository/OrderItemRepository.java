package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
