package com.asm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@FutureOrPresent(message = "Date should not be in past")
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name = "order_status")
	private String orderStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@OneToOne(mappedBy = "order")
	private Shipment shipment;
	@Column(name = "to_warehouse_id")
	private int toWarehouseId;
	@Column(name = "from_warehouse_id")
	private int fromWarehouseId;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(int toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public int getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(int fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}
	

}
