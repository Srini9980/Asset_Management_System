package com.asm.exception;

@SuppressWarnings("serial")
public class ShipmentNotFoundException extends RuntimeException {
	
	public ShipmentNotFoundException(String message) {
		super(message);
	}

}
