package com.asm.service;

import java.util.List;

import com.asm.entity.Warehouse;

public interface WarehouseService {

	public Warehouse saveWarehouse(Warehouse warehouse);

	public Warehouse updateWarehouse(Warehouse warehouse);

	public void deleteWarehouse(int warehouseId);

	public List<Warehouse> getAllWarehouse();

	public Warehouse getWarehouseById(int warehouseId);

	public List<Warehouse> getByWarehouseName(String WarehouseName);
	
	public List<Warehouse> getByWarehouseLocation(String warehouseLocations);

}
