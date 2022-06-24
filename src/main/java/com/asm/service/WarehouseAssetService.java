package com.asm.service;

import java.util.List;

import com.asm.entity.WarehouseAsset;

public interface WarehouseAssetService {
	
	public WarehouseAsset addWarehouseAsset(WarehouseAsset warehouseAsset);
	
	public WarehouseAsset getWarehouseAssetById(int warehouseAssetId);
	
	public List<WarehouseAsset> getAllWarehouseAsset();
	

}
