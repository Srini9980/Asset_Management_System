package com.asm.exception;

@SuppressWarnings("serial")
public class OrderItemNotFoundException extends RuntimeException{
	
	public OrderItemNotFoundException(String msg) {
		super(msg);
	}

}
