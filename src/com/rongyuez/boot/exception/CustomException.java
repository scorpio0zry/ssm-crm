package com.rongyuez.boot.exception;

public class CustomException extends RuntimeException{

	/**
	 * 自定义异常类
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
	
	 
	
}
