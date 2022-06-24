package com.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
