package com.asm.service;

import java.util.List;

import com.asm.entity.Asset;

public interface AssetService {
	
	public Asset addAsset(Asset asset);

	public void deleteAsset(int assetId);

	public Asset modifyAsset(Asset asset);

	public Asset getAssetById(int assetId);

	public List<Asset> getAllAssetsByType(String assetType);

	public List<Asset> getAllAssetsByCategory(String assetCategory);

	public List<Asset> getAllAssetsByName(String assetName);

	public List<Asset> getAllAssetsByPrice(double assetPrice);

	public List<Asset> getAllAssets();

}
