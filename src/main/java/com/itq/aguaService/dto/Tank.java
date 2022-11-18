package com.itq.aguaService.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Tank {
	private static int CONT_TANK = 1;
	
	private int idTank;
	@NotEmpty
	@NotNull
	private String nameTank;
	private int fillTime;
	private int currentContent;
	@NotNull
	@Min(1)
	private int size;
	private String state;
	
	/**
	 * Default constructor of Tank class
	 * */
	public Tank() {
		
	}
	
	/**
	 * Gets Tank id
	 * @return int value with the tank id
	 * */
	public int getIdTank() {
		return idTank;
	}
	
	/**
	 * Sets Tank id
	 * */
	public void setIdTank() {
		this.idTank = CONT_TANK;
		Tank.CONT_TANK++;
	}
	
	/**
	 * Gets Tank name
	 * @return String value with the tank name
	 * */
	public String getNameTank() {
		return nameTank;
	}
	
	/**
	 * Sets Tank name
	 * @param String value with the tank name
	 * */
	public void setNameTank(String nameTank) {
		this.nameTank = nameTank;
	}
	
	/**
	 * Gets Tank fill time
	 * @return int value with the tank fill time
	 * */
	public int getFillTime() {
		return fillTime;
	}
	
	/**
	 * Sets Tank fill time
	 * @param int value with the tank fill time
	 * */
	public void setFillTime(int fillTime) {
		this.fillTime = fillTime;
	}
	
	/**
	 * Gets Tank current content
	 * @return int value with the tank current content
	 * */
	public int getCurrentContent() {
		return currentContent;
	}
	
	/**
	 * Sets Tank current content
	 * @param int value with the tank current content
	 * */
	public void setCurrentContent(int currentContent) {
		this.currentContent = currentContent;
	}
	
	/**
	 * Gets Tank size
	 * @return int value with the tank size
	 * */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets Tank size
	 * @param int value with the tank size
	 * */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Gets Tank state
	 * @return String value with the tank state
	 * */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets Tank state
	 * @param String value with the tank state
	 * */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets Tank info
	 * @return String value with the tank info
	 * */
	@Override
	public String toString() {
		return "Tank [idTank=" + idTank + ", nameTank=" + nameTank + ", fillTime=" + fillTime + ", currentContent="
				+ currentContent + ", size=" + size + ", state=" + state + "]";
	}
	
}

