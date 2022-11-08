package com.itq.aguaService.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Tank {
	
	// Variable de clase de la hora de llenado, siempre es a las 00:00
	//private final static Date FILL_TIME = new Date();
	
	private static int CONT_TANK = 1;
	
	private int idTank;
	@NotEmpty
	@NotNull
	private String nameTank;
	@NotEmpty
	@NotNull
	private int fillTime;
	private int currentContent;
	@NotEmpty
	@NotNull
	@Min(1)
	private int size;
	private String state;
		
	public Tank() {
		this.idTank = Tank.CONT_TANK;
		Tank.CONT_TANK++;
	}
	
	public int getIdTank() {
		return idTank;
	}
	
	public void setIdTank(int idTank) {
		this.idTank = idTank;
	}
	
	public String getNameTank() {
		return nameTank;
	}
	
	public void setNameTank(String nameTank) {
		this.nameTank = nameTank;
	}
	
	public int getFillTime() {
		return fillTime;
	}
	
	public void setFillTime(int fillTime) {
		this.fillTime = fillTime;
	}
	
	public int getCurrentContent() {
		return currentContent;
	}
	
	public void setCurrentContent(int currentContent) {
		this.currentContent = currentContent;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Tank [idTank=" + idTank + ", nameTank=" + nameTank + ", fillTime=" + fillTime + ", currentContent="
				+ currentContent + ", size=" + size + ", state=" + state + "]";
	}
	
}

