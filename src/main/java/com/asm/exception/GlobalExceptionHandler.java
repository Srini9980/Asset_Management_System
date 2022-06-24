package com.asm.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ShipmentNotFoundException.class)
	public ResponseEntity<String> handleShipmentNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = AuthenticationFailedException.class)
	public ResponseEntity<String> handleAuthenticationFailedException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = WarehouseNotFoundException.class)
	public ResponseEntity<String> handleWarehouseNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(value = WarehouseAssetNotFoundException.class)
	public ResponseEntity<String> handleWarehouseAssetNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = OrderItemNotFoundException.class)
	public ResponseEntity<String> handleOrderItemNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(value = AssetNotFoundException.class)
	public ResponseEntity<String> handleAssetNotFoundException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("status", status.value());

		// Get all errors
		List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
}