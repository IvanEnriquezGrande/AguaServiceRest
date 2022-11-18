package com.itq.aguaService.dto;

public class Ack {
	private int code;
	private String description;
	private String extra;
	
	/**
	 * Default constructor of Ack class
	 * */
	public Ack() {
		super();
	}
	
	/**
	 * Gets Ack code
	 * @return int value with the Ack code
	 * */
	public int getCode() {
		return code;
	}
	
	/**
	 * Sets Ack code
	 * @param int value with the Ack code
	 * */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * Gets Ack description
	 * @return String value with the Ack description
	 * */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets Ack description
	 * @param String value with the Ack description
	 * */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets Ack extra info
	 * @return String value with the Ack extra info
	 * */
	public String getExtra() {
		return extra;
	}
	
	/**
	 * Sets Ack extra info
	 * @param String value with the Ack extra info
	 * */
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	/**
	 * Gets Ack info
	 * @return String value with the Ack info
	 * */
	@Override
	public String toString() {
		return "Ack [code=" + code + ", description=" + description + "]";
	}
	
}
