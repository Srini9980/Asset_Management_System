package com.asm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "warehouse_table")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private int warehouseId;
	@NotNull(message = "warehouse name is required")
	@NotBlank(message = "Warehouse name should not be blank")
	@Column(name = "warehouse_name")
	private String warehouseName;
	@NotNull(message = "Warehouse location is required")
	@Column(name = "warehouse_locations")
	private String warehouseLocations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.PERSIST)
    private List<WarehouseAsset> assets;
	
	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseLocations() {
		return warehouseLocations;
	}

	public void setWarehouseLocations(String warehouseLocations) {
		this.warehouseLocations = warehouseLocations;
	}

	public List<WarehouseAsset> getAssets() {
		return assets;
	}

	public void setAssets(List<WarehouseAsset> assets) {
		this.assets = assets;
	}

}
