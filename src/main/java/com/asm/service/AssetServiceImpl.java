package com.asm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.entity.Asset;
import com.asm.exception.AssetNotFoundException;
import com.asm.repository.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService {
	
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Asset addAsset(Asset asset) {
		
		Asset addedAsset = assetRepository.save(asset);
		return addedAsset;
	}

	@Override
	public void deleteAsset(int assetId) {
		
		Optional<Asset> optionalAsset =assetRepository.findById(assetId);
		if (optionalAsset.isEmpty()) {
			throw new AssetNotFoundException("Asset not found with thid id : " + assetId);
		}

		assetRepository.deleteById(assetId);
		
	}

	@Override
	public Asset modifyAsset(Asset asset) {
		
		Optional<Asset> optionalAsset = assetRepository.findById(asset.getAssetId());
		if (optionalAsset.isEmpty()) {
			throw new AssetNotFoundException("Asset Not found with  " + asset.getAssetId() + "Id");
		}
		Asset modifiedAsset = assetRepository.save(asset);
		return modifiedAsset;
	}

	@Override
	public Asset getAssetById(int assetId) {
		
		Optional<Asset> optionalAsset = assetRepository.findById(assetId);
		if (optionalAsset.isEmpty()) {
			throw new AssetNotFoundException("Asset Not found with id: " + assetId);
		}
		Asset assetById = optionalAsset.get();
		return assetById;
	}

	@Override
	public List<Asset> getAllAssetsByType(String assetType) {
		
		List<Asset> listOfAssetByType = assetRepository.findByAssetType(assetType);
		if (listOfAssetByType.size() == 0) {
			throw new AssetNotFoundException("Asset Not found with type: " + assetType);
		}
		return listOfAssetByType;
	}

	@Override
	public List<Asset> getAllAssetsByCategory(String assetCategory) {
		
		List<Asset> listOfAssetsByName = assetRepository.findByAssetCategory(assetCategory);
		if (listOfAssetsByName.size() == 0) {
			throw new AssetNotFoundException("Assets Not found with category: " + assetCategory);
		}

		return listOfAssetsByName;
	}

	@Override
	public List<Asset> getAllAssetsByName(String assetName) {
		
		List<Asset> listOfAssetsByName = assetRepository.findByAssetName(assetName);
		if (listOfAssetsByName.size() == 0) {
			throw new AssetNotFoundException("Assets Not found with name: " + assetName);
		}

		return listOfAssetsByName;
	}

	@Override
	public List<Asset> getAllAssetsByPrice(double assetPrice) {
		
		List<Asset> listOfAssetsByPrice = assetRepository.findByAssetPrice(assetPrice);
		if (listOfAssetsByPrice.size() == 0) {
			throw new AssetNotFoundException("Asset Not found with id: " + assetPrice);
		}
		return listOfAssetsByPrice;
	}

	@Override
	public List<Asset> getAllAssets() {
	
		List<Asset> assets = assetRepository.findAll();
		return assets;
	}

}
