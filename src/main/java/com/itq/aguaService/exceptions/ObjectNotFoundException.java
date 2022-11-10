package com.itq.aguaService.exceptions;

public class ObjectNotFoundException extends Exception{
	private String description;
	private final static int CODE = 401;
	
	public ObjectNotFoundException(String description) {
		super(description + " , code" + ObjectNotFoundException.CODE);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
