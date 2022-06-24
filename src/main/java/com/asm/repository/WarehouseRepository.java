package com.asm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asm.entity.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
	
	public List<Warehouse> findByWarehouseName(String warehouseName);
	
	public List<Warehouse> findByWarehouseLocations(String warehouseLocations);
}