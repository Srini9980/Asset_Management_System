package com.asm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.asm.entity.Shipment;
import com.asm.exception.ShipmentNotFoundException;
import com.asm.repository.ShipmentRepository;

@SpringBootTest
public class ShipmentServiceTest {

	@InjectMocks
	private ShipmentService shipmentService = new ShipmentServiceImpl();

	@Mock
	private ShipmentRepository shipmentRepository;

	@Test
	 void testGetShipmentById() {

		Shipment shipment = new Shipment();
		shipment.setShipId(10);
		shipment.setShipAssets("Hardware");
		shipment.setShipStatus("deliverd_succesfully");
		shipment.setDateOfShipment(LocalDate.now());
		shipment.setLocation("Banaglore");
		shipment.setSubLocation("RRNagar");
		shipment.setState("Karnataka");
		shipment.setCountry("India");
		shipment.setFromWarehouseId(1);
		shipment.setToWarehouseId(2);

		Optional<Shipment> optionalShipment = Optional.of(shipment);

		when(shipmentRepository.findById(10)).thenReturn(optionalShipment);

		Shipment myShipment = shipmentService.getShipmentById(10);

		assertEquals("Hardware", myShipment.getShipAssets());

	}

	@Test
	 void testGetShipmentByIdWithException() {

		when(shipmentRepository.findById(10)).thenThrow(ShipmentNotFoundException.class);

		assertThrows(ShipmentNotFoundException.class, () -> shipmentService.getShipmentById(10));
	}

	@Test
	 void tsetGelAllProduct() {

		Shipment shipment1 = new Shipment();
		shipment1.setShipId(10);
		shipment1.setShipAssets("Hardware");
		shipment1.setShipStatus("deliverd_succesfully");
		shipment1.setDateOfShipment(LocalDate.now());
		shipment1.setLocation("Banaglore");
		shipment1.setSubLocation("RRNagar");
		shipment1.setState("Karnataka");
		shipment1.setCountry("India");
		shipment1.setFromWarehouseId(1);
		shipment1.setToWarehouseId(2);

		Shipment shipment2 = new Shipment();
		shipment2.setShipId(20);
		shipment2.setShipAssets("Hardware");
		shipment2.setShipStatus("pending");
		shipment2.setDateOfShipment(LocalDate.now());
		shipment2.setLocation("Chennai");
		shipment2.setSubLocation("Adyar");
		shipment2.setState("Tamil_nadu");
		shipment2.setCountry("India");
		shipment2.setFromWarehouseId(2);
		shipment2.setToWarehouseId(1);

		Shipment shipment3 = new Shipment();
		shipment3.setShipId(30);
		shipment3.setShipAssets("Software");
		shipment3.setShipStatus("yet_to_be_delivered");
		shipment3.setDateOfShipment(LocalDate.now());
		shipment3.setLocation("Mumbai");
		shipment3.setSubLocation("Dharavi");
		shipment3.setState("Maharastra");
		shipment3.setCountry("India");
		shipment3.setFromWarehouseId(1);
		shipment3.setToWarehouseId(2);

		List<Shipment> shipmentList = new ArrayList<>();
		shipmentList.add(shipment1);
		shipmentList.add(shipment2);
		shipmentList.add(shipment3);

		when(shipmentRepository.findAll()).thenReturn(shipmentList);

		List<Shipment> shipment = shipmentService.getAllShipment();

		assertEquals(3, shipment.size());

	}

	@Test
	 void testSaveShipment() {

		Shipment shipment = new Shipment();
		shipment.setShipId(10);
		shipment.setShipAssets("Hardware");
		shipment.setShipStatus("deliverd_succesfully");
		shipment.setDateOfShipment(LocalDate.now());
		shipment.setLocation("Banaglore");
		shipment.setSubLocation("RRNagar");
		shipment.setState("Karnataka");
		shipment.setCountry("India");
		shipment.setFromWarehouseId(1);
		shipment.setToWarehouseId(2);

		when(shipmentRepository.save(shipment)).thenReturn(shipment);

		Shipment newShipment = shipmentService.saveShipment(shipment);

		assertEquals("Hardware", newShipment.getShipAssets());

		verify(shipmentRepository, times(1)).save(shipment);
	}

	@Test
	 void testDeleteShipment() {

		Shipment shipment = new Shipment();
		shipment.setShipId(10);
		shipment.setShipAssets("Hardware");
		shipment.setShipStatus("deliverd_succesfully");
		shipment.setDateOfShipment(LocalDate.now());
		shipment.setLocation("Banaglore");
		shipment.setSubLocation("RRNagar");
		shipment.setState("Karnataka");
		shipment.setCountry("India");
		shipment.setFromWarehouseId(1);
		shipment.setToWarehouseId(2);

		Optional<Shipment> optionalShipment = Optional.of(shipment);

		when(shipmentRepository.findById(10)).thenReturn(optionalShipment);

		shipmentService.deleteShipmentById(10);

		verify(shipmentRepository, times(1)).findById(10);
		verify(shipmentRepository, times(1)).deleteById(10);
	}

	@Test
	 void testUpdateShipment() {

		Shipment shipment = new Shipment();
		shipment.setShipId(10);
		shipment.setShipAssets("Hardware");
		shipment.setShipStatus("deliverd_succesfully");
		shipment.setDateOfShipment(LocalDate.now());
		shipment.setLocation("Banaglore");
		shipment.setSubLocation("RRNagar");
		shipment.setState("Karnataka");
		shipment.setCountry("India");
		shipment.setFromWarehouseId(1);
		shipment.setToWarehouseId(2);

		Optional<Shipment> optionalShipment = Optional.of(shipment);

		when(shipmentRepository.findById(10)).thenReturn(optionalShipment);

		shipmentService.updateShipment(shipment);

		verify(shipmentRepository, times(1)).findById(10);
		verify(shipmentRepository, times(1)).save(shipment);

	}

}
