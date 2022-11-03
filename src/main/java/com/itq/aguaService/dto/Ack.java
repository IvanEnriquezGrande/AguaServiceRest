package com.itq.aguaService.dto;

public class Ack {
	private int code;
	private String description;
	
	public Ack() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ack [code=" + code + ", description=" + description + "]";
	}
	
}
