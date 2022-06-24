package com.asm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.asm.entity.Asset;
import com.asm.entity.Warehouse;
import com.asm.entity.WarehouseAsset;
import com.asm.entity.WarehouseAssetKey;
import com.asm.exception.WarehouseAssetNotFoundException;
import com.asm.repository.WarehouseAssetRepository;

@SpringBootTest
class WarehouseAssetServiceTest {

	@InjectMocks
	private WarehouseAssetService warehouseAssetService = new WarehouseAssetServiceImpl();

	@Mock
	private WarehouseAssetRepository warehouseAssetRepository;

	@Test
	 void testGetWarehouseAssetById() {

		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetName("Dell");
		asset.setAssetType("Laptop");
		asset.setAssetPrice(56000);
		asset.setAssetCategory("Hardware");
		asset.setManufacturer("Dell-INC");

		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(1);
		warehouse.setWarehouseLocations("Bangalore");
		warehouse.setWarehouseName("publicWarehouse");

		WarehouseAssetKey warehouseAssetKey = new WarehouseAssetKey();
		warehouseAssetKey.setAssetId(1);
		warehouseAssetKey.setWarehouseId(1);

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		warehouseAsset.setAsset(asset);
		warehouseAsset.setId(warehouseAssetKey);
		warehouseAsset.setNoOfItems(101);
		warehouseAsset.setWarehouse(warehouse);

		Optional<WarehouseAsset> optionalWarehouseAsset = Optional.of(warehouseAsset);

		when(warehouseAssetRepository.findById(1)).thenReturn(optionalWarehouseAsset);

		WarehouseAsset myWarehouseAsset = warehouseAssetService.getWarehouseAssetById(1);

		assertEquals(101, myWarehouseAsset.getNoOfItems());
	}

	@Test
	 void testGetWarehouseAssetByIdWithException() {

		when(warehouseAssetRepository.findById(2)).thenThrow(WarehouseAssetNotFoundException.class);

		assertThrows(WarehouseAssetNotFoundException.class, () -> warehouseAssetService.getWarehouseAssetById(1));
	}

	
	@Test
	 void testGetAllWarehouseAsset() {
		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetName("Dell");
		asset.setAssetType("Laptop");
		asset.setAssetPrice(56000);
		asset.setAssetCategory("Hardware");
		asset.setManufacturer("Dell-INC");

		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(1);
		warehouse.setWarehouseLocations("Bangalore");
		warehouse.setWarehouseName("privateWarehouse");

		WarehouseAssetKey warehouseAssetKey = new WarehouseAssetKey();
		warehouseAssetKey.setAssetId(1);
		warehouseAssetKey.setWarehouseId(1);


		WarehouseAsset warehouseAsset = new WarehouseAsset();
		warehouseAsset.setAsset(asset);
		warehouseAsset.setId(warehouseAssetKey);
		warehouseAsset.setNoOfItems(102);
		warehouseAsset.setWarehouse(warehouse);
		
		
		Asset asset2 = new Asset();
		asset2.setAssetId(2);
		asset2.setAssetName("Samsung");
		asset2.setAssetType("Laptop");
		asset2.setAssetPrice(60000);
		asset2.setAssetCategory("Hardware");
		asset2.setManufacturer("Samsung-INC");

		Warehouse warehouse2 = new Warehouse();
		warehouse2.setWarehouseId(2);
		warehouse2.setWarehouseLocations("Hubli");
		warehouse2.setWarehouseName("privateWarehouse");

		WarehouseAssetKey warehouseAssetKey2 = new WarehouseAssetKey();
		warehouseAssetKey2.setAssetId(2);
		warehouseAssetKey2.setWarehouseId(2);
		WarehouseAsset warehouseAsset2 = new WarehouseAsset();
		warehouseAsset2.setAsset(asset);
		warehouseAsset2.setId(warehouseAssetKey);
		warehouseAsset2.setNoOfItems(103);
		warehouseAsset2.setWarehouse(warehouse);


		
		Asset asset3 = new Asset();
		asset3.setAssetId(3);
		asset3.setAssetName("Hp");
		asset3.setAssetType("Laptop");
		asset3.setAssetPrice(67000);
		asset3.setAssetCategory("Hardware");
		asset3.setManufacturer("Hp-INC");

		Warehouse warehouse3 = new Warehouse();
		warehouse3.setWarehouseId(3);
		warehouse3.setWarehouseLocations("Bangalore");
		warehouse3.setWarehouseName("privateWarehouse");

		WarehouseAssetKey warehouseAssetKey3 = new WarehouseAssetKey();
		warehouseAssetKey3.setAssetId(3);
		warehouseAssetKey3.setWarehouseId(3);


		WarehouseAsset warehouseAsset3 = new WarehouseAsset();
		warehouseAsset3.setAsset(asset);
		warehouseAsset3.setId(warehouseAssetKey);
		warehouseAsset3.setNoOfItems(104);
		warehouseAsset3.setWarehouse(warehouse);

		  
		  
		List<WarehouseAsset> warehouseAssetList = new ArrayList<>();

		warehouseAssetList.add(warehouseAsset3);
		warehouseAssetList.add(warehouseAsset2);
		warehouseAssetList.add(warehouseAsset);

		when(warehouseAssetRepository.findAll()).thenReturn(warehouseAssetList);

		List<WarehouseAsset> WarehouseAsset = warehouseAssetService.getAllWarehouseAsset();

		assertEquals(3, WarehouseAsset.size());
	}

	@Test
	 void testaddWarehouseAssetService() {
		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetName("Dell");
		asset.setAssetType("Laptop");
		asset.setAssetPrice(56000);
		asset.setAssetCategory("Hardware");
		asset.setManufacturer("Dell-INC");

		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(1);
		warehouse.setWarehouseLocations("Bangalore");
		warehouse.setWarehouseName("privateWarehouse");

		WarehouseAssetKey warehouseAssetKey = new WarehouseAssetKey();
		warehouseAssetKey.setAssetId(1);
		warehouseAssetKey.setWarehouseId(1);

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		warehouseAsset.setAsset(asset);
		warehouseAsset.setId(warehouseAssetKey);
		warehouseAsset.setNoOfItems(102);
		warehouseAsset.setWarehouse(warehouse);

		when(warehouseAssetRepository.save(warehouseAsset)).thenReturn(warehouseAsset);

		WarehouseAsset newWarehouseAsset = warehouseAssetService.addWarehouseAsset(warehouseAsset);

		assertEquals("Dell", newWarehouseAsset.getAsset().getAssetName());

		verify(warehouseAssetRepository, times(1)).save(warehouseAsset);

	}

}
