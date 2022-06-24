package com.asm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.WarehouseAsset;
import com.asm.service.WarehouseAssetService;

@RestController
public class WarehouseAssetContrller {

	@Autowired
	private WarehouseAssetService warehouseAssetService;

	@PostMapping("/warehouseAsset/save")
	public ResponseEntity<WarehouseAsset> saveWarehouseAsset(@Valid @RequestBody WarehouseAsset warehouseAsset) {

		WarehouseAsset newWarehouseAsset = warehouseAssetService.addWarehouseAsset(warehouseAsset);
		ResponseEntity<WarehouseAsset> responseEntity = new ResponseEntity<>(newWarehouseAsset, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/warehouseAsset/all")
	public List<WarehouseAsset> fetchAllWarehouseAsset() {

		return warehouseAssetService.getAllWarehouseAsset();
	}

	@GetMapping("/warehouseAsset/find/{warehouseAssetId}")
	public ResponseEntity<Object> fetchWarehouseAssetById(@PathVariable("warehouseAssetId") int warehouseAssetId) {

		ResponseEntity<Object> responseEntity = null;
		WarehouseAsset warehouseAsset = warehouseAssetService.getWarehouseAssetById(warehouseAssetId);
		responseEntity = new ResponseEntity<>(warehouseAsset, HttpStatus.OK);
		return responseEntity;
	}

}
