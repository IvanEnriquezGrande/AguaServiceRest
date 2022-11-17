package com.itq.aguaService.dto;

import java.util.ArrayList;

public class Ack {
	private int code;
	private String description;
	private String extra;
	
	
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

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
}
