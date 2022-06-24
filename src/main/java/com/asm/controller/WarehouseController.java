package com.asm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asm.entity.Warehouse;
import com.asm.service.WarehouseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	@PostMapping("/warehouse/save")
	public ResponseEntity<Warehouse> addWarehouse(@Valid @RequestBody Warehouse product) {

		Warehouse newWarehouse = warehouseService.saveWarehouse(product);
		ResponseEntity<Warehouse> responseEntity = new ResponseEntity<>(newWarehouse, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/warehouse/all")
	public List<Warehouse> fetchAllWarehouses() {

		List<Warehouse> warehouses = warehouseService.getAllWarehouse();
		return warehouses;
	}

	@GetMapping("/warehouse/find{wId}")
	public ResponseEntity<Object> fetchWarehouseById(@PathVariable("wId") int warehouseId) {

		ResponseEntity<Object> responseEntity = null;
		Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
		responseEntity = new ResponseEntity<>(warehouse, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/warehouse/bywarehousename/{whName}")
	public ResponseEntity<Object> fetchProductByName(@PathVariable("whName") String warehouseName) {

		ResponseEntity<Object> responseEntity = null;
		List<Warehouse> warehouse = warehouseService.getByWarehouseName(warehouseName);
		responseEntity = new ResponseEntity<>(warehouse, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/warehouse/delete/{warehouseId}")
	public ResponseEntity<String> removeProduct(@PathVariable("warehouseId") int warehouseId) {

		warehouseService.deleteWarehouse(warehouseId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Warehouse Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/warehouse/update")
	public ResponseEntity<Warehouse> modifyProduct(@RequestBody Warehouse warehouse) {

		Warehouse updatedProduct = warehouseService.updateWarehouse(warehouse);
		ResponseEntity<Warehouse> responseEntity = new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/warehouse/bylocation/{wlocations}")
	public ResponseEntity<Object> fetchWarehouseByLocations(@PathVariable("wlocations") String warehouseLocations) {

		ResponseEntity<Object> responseEntity = null;
		List<Warehouse> warehouse = warehouseService.getByWarehouseLocation(warehouseLocations);
		responseEntity = new ResponseEntity<>(warehouse, HttpStatus.OK);
		return responseEntity;
	}

}