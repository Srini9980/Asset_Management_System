package com.asm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.asm.entity.Warehouse;
import com.asm.repository.WarehouseRepository;

@SpringBootTest
class WarehouseServiceTest {

	@InjectMocks
	private WarehouseService warehouseService = new WarehouseServiceImpl();

	@Mock
	private WarehouseRepository warehouseRepository;

	@Test
	void testWarehouseById() {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(10);
		warehouse.setWarehouseName("abc-1");
		warehouse.setWarehouseLocations("pune");

		Optional<Warehouse> optionalWarehouse = Optional.of(warehouse);
		when(warehouseRepository.findById(10)).thenReturn(optionalWarehouse);
		Warehouse myWarehouse = warehouseService.getWarehouseById(10);
		assertEquals("abc-1", myWarehouse.getWarehouseName());
	}

	@Test
	void testAddWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(10);
		warehouse.setWarehouseName("abc-1");
		warehouse.setWarehouseLocations("pune");

		when(warehouseRepository.save(warehouse)).thenReturn(warehouse);

	}

	@Test
	void testUpdateWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(10);
		warehouse.setWarehouseName("abc-1");
		warehouse.setWarehouseLocations("pune");

		Optional<Warehouse> optionalWarehouse = Optional.of(warehouse);
		when(warehouseRepository.findById(10)).thenReturn(optionalWarehouse);
		warehouseService.updateWarehouse(warehouse);

		verify(warehouseRepository, times(1)).findById(10);
		verify(warehouseRepository, times(1)).save(warehouse);
	}

	@Test
	void testRemoveWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(10);
		warehouse.setWarehouseName("abc-1");
		warehouse.setWarehouseLocations("pune");

		Optional<Warehouse> optionalWarehouse = Optional.of(warehouse);
		when(warehouseRepository.findById(10)).thenReturn(optionalWarehouse);
		warehouseService.deleteWarehouse(10);

		verify(warehouseRepository, times(1)).deleteById(10);

	}

	@Test
	void testGetWarehouseByName() {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(10);
		warehouse.setWarehouseName("warehouse-mumbai");
		warehouse.setWarehouseLocations("mumbai");

		Warehouse warehouse1 = new Warehouse();
		warehouse1.setWarehouseId(20);
		warehouse1.setWarehouseName("warehouse-pune");
		warehouse1.setWarehouseLocations("pune");

		Warehouse warehouse2 = new Warehouse();
		warehouse2.setWarehouseId(30);
		warehouse2.setWarehouseName("warehouse-bangalore");
		warehouse2.setWarehouseLocations("bangalore");

		List<Warehouse> listOfWarehouseByName = new ArrayList<>();
		listOfWarehouseByName.add(warehouse);
		listOfWarehouseByName.add(warehouse1);
		listOfWarehouseByName.add(warehouse2);

		when(warehouseRepository.findByWarehouseName("warehouse-bangalore")).thenReturn(listOfWarehouseByName);

		List<Warehouse> warehouseByName = warehouseService.getByWarehouseName("warehouse-bangalore");

		assertEquals(3, warehouseByName.size());

	}

	@Test
	void testGetWarehouseByLocation() {
		Warehouse warehouse1 = new Warehouse();
		warehouse1.setWarehouseId(10);
		warehouse1.setWarehouseName("warehouse-pune");
		warehouse1.setWarehouseLocations("pune");

		Warehouse warehouse2 = new Warehouse();
		warehouse2.setWarehouseId(10);
		warehouse2.setWarehouseName("warehouse-pune");
		warehouse2.setWarehouseLocations("pune");

		Warehouse warehouse3 = new Warehouse();
		warehouse3.setWarehouseId(10);
		warehouse3.setWarehouseName("warehouse-pune");
		warehouse3.setWarehouseLocations("pune");

		List<Warehouse> warehouseList = new ArrayList<>();
		warehouseList.add(warehouse1);
		warehouseList.add(warehouse2);
		warehouseList.add(warehouse3);

		when(warehouseRepository.findByWarehouseLocations("pune")).thenReturn(warehouseList);

		List<Warehouse> warehouses = warehouseService.getByWarehouseLocation("pune");

		assertEquals(3, warehouses.size());
	}

	@Test
	void testGetAllWarehouses() {

		Warehouse warehouse1 = new Warehouse();

		warehouse1.setWarehouseId(1);
		warehouse1.setWarehouseName("warehouse1");
		warehouse1.setWarehouseLocations("pune");

		Warehouse warehouse2 = new Warehouse();

		warehouse2.setWarehouseId(2);
		warehouse2.setWarehouseName("warehouse2");
		warehouse2.setWarehouseLocations("mumbai");

		Warehouse warehouse3 = new Warehouse();

		warehouse3.setWarehouseId(3);
		warehouse3.setWarehouseName("warehouse3");
		warehouse3.setWarehouseLocations("delhi");

		List<Warehouse> warehouseList = new ArrayList<>();
		warehouseList.add(warehouse1);
		warehouseList.add(warehouse2);
		warehouseList.add(warehouse3);

		when(warehouseRepository.findAll()).thenReturn(warehouseList);

		List<Warehouse> warehouses = warehouseService.getAllWarehouse();

		assertEquals(3, warehouses.size());

	}
}
