package com.asm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.entity.WarehouseAsset;
import com.asm.exception.WarehouseAssetNotFoundException;
import com.asm.repository.WarehouseAssetRepository;

@Service
public class WarehouseAssetServiceImpl implements WarehouseAssetService {

	@Autowired
	private WarehouseAssetRepository warehouseAssetRepository;
	
	@Override
	public WarehouseAsset addWarehouseAsset(WarehouseAsset warehouseAsset) {
		
		WarehouseAsset savedWarehouseAsset = warehouseAssetRepository.save(warehouseAsset);
		return savedWarehouseAsset;
	}

	@Override
	public WarehouseAsset getWarehouseAssetById(int warehouseAssetId) {
		
		Optional<WarehouseAsset> optionalWarehouseAsset = warehouseAssetRepository.findById(warehouseAssetId);
		if(optionalWarehouseAsset.isEmpty()) {
			throw new WarehouseAssetNotFoundException("WarehouseAsset not found with thid Id :" + warehouseAssetId);
		}
		WarehouseAsset warehouseAssetById = optionalWarehouseAsset.get();
		return warehouseAssetById;
	}

	@Override
	public List<WarehouseAsset> getAllWarehouseAsset() {
	    
		List<WarehouseAsset> allWarehouseAsset = warehouseAssetRepository.findAll();
		return allWarehouseAsset;
	}

}
