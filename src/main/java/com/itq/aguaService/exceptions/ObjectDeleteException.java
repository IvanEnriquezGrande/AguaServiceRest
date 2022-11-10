package com.itq.aguaService.exceptions;

public class ObjectDeleteException extends Exception {
	
	private String description;
	private static final int CODE = 402;
	
	public ObjectDeleteException(String description) {
		super("Delete Error:" + description + ", CODE: " + ObjectDeleteException.CODE);
		this.description = description;
	}

	public int getCODE() {
		return CODE;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
