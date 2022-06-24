package com.asm.exception;

@SuppressWarnings("serial")
public class WarehouseAssetNotFoundException extends RuntimeException {
	
	public WarehouseAssetNotFoundException(String message) {
		super(message);
	}

}
