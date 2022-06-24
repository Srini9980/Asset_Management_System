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
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "asset_table")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private int assetId;
	@NotBlank(message = "Asset name can't be empty")
	@NotNull(message = "Asset name is required")
	@Column(name = "asset_name")
	private String assetName;
	@Positive(message = "Asset price can't be in nagative value")
	@Column(name = "asset_price")
	private double assetPrice;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "asset_category")
	private String assetCategory;
	@Column(name = "asset_type")
	private String assetType;

	@JsonIgnore
	@OneToMany(mappedBy = "asset" , cascade = CascadeType.ALL)
	private List<WarehouseAsset> assets;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public double getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(double assetPrice) {
		this.assetPrice = assetPrice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public List<WarehouseAsset> getAssets() {
		return assets;
	}

	public void setAssets(List<WarehouseAsset> assets) {
		this.assets = assets;
	}

}
