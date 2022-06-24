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

import com.asm.entity.Asset;
import com.asm.service.AssetService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AssetConroller {

	@Autowired
	private AssetService assetService;

	@PostMapping("/asset/add")
	public ResponseEntity<Asset> addAsset(@Valid @RequestBody Asset asset) {
		Asset newAsset = assetService.addAsset(asset);
		ResponseEntity<Asset> responseEntity = new ResponseEntity<>(newAsset, HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/asset/delete/{assetId}")
	public ResponseEntity<String> removeAsset(@PathVariable("assetId") int assetId) {

		assetService.deleteAsset(assetId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Asset Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/asset/modify")
	public ResponseEntity<Asset> modifyAsset(@RequestBody Asset asset) {

		Asset modifiedAsset = assetService.modifyAsset(asset);
		ResponseEntity<Asset> responseEntity = new ResponseEntity<>(modifiedAsset, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/asset/find/byId/{assetId}")
	public ResponseEntity<Object> fetchAssetById(@PathVariable("assetId") int assetId) {
		ResponseEntity<Object> responseEntity = null;
		Asset asset = assetService.getAssetById(assetId);
		responseEntity = new ResponseEntity<Object>(asset, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/asset/all/byName/{assetName}")
	public List<Asset> fetchAssetByName(@PathVariable("assetName") String assetName) {
		List<Asset> assets = assetService.getAllAssetsByName(assetName);
		return assets;
	}

	@GetMapping("/asset/all/byPrice/{assetPrice}")
	public List<Asset> fetchAssetByPrice(@PathVariable("assetPrice") double assetPrice) {
		List<Asset> assets = assetService.getAllAssetsByPrice(assetPrice);
		return assets;
	}

	@GetMapping("/asset/all/byCategory/{assetCategory}")
	public List<Asset> fetchAssetByCategory(@PathVariable("assetCategory") String assetCategory) {
		List<Asset> assets = assetService.getAllAssetsByCategory(assetCategory);
		return assets;
	}

	@GetMapping("/asset/all/byType/{assetType}")
	public List<Asset> fetchAssetByType(@PathVariable("assetType") String assetType) {
		List<Asset> assets = assetService.getAllAssetsByType(assetType);
		return assets;
	}

	@GetMapping("/asset/all")
	public List<Asset> fetchAllAssets() {
		List<Asset> assets = assetService.getAllAssets();
		return assets;
	}

}
