package com.asm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shipment_table")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipment_id")
	private int shipId;
	@NotNull(message = "Shipment asset is required")
	@Column(name = "shipment_assets")
	private String shipAssets;
	@Column(name = "shipment_status")
	private String shipStatus;
	@Column(name = "ship_sub_location")
	private String subLocation;
	@FutureOrPresent(message = "Date should not be in past")
	@Column(name = "date_of_shipment")
	private LocalDate dateOfShipment;
	@NotNull(message = "Shipment location is required")
	@Column(name = "ship_location")
	private String location;
	@Column(name = "ship_state")
	private String state;
	@Column(name = "ship_country")
	private String country;
	@NotNull(message = "From location is required")
	@Column(name = "from_warehouse_id")
	private int fromWarehouseId;
	@NotNull(message = "To location is required")
	@Column(name = "to_warehouse_id")
	private int toWarehouseId;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public String getShipAssets() {
		return shipAssets;
	}

	public void setShipAssets(String shipAssets) {
		this.shipAssets = shipAssets;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(int fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public int getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(int toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public LocalDate getDateOfShipment() {
		return dateOfShipment;
	}

	public void setDateOfShipment(LocalDate dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
