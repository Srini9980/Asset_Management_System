package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	

}
