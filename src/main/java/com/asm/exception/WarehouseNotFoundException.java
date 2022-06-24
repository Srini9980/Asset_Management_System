package com.asm.exception;

@SuppressWarnings("serial")
public class WarehouseNotFoundException extends RuntimeException {

	public WarehouseNotFoundException(String message) {
		super(message);
	}

}
