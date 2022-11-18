package com.itq.aguaService.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;  

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Request {

	private static int CONT_REQUEST = 1;
	private static final SimpleDateFormat FORMATER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	private int idRequest;
	@NotNull
	private int idClient;
	private int idTank;
	@Min(1)
	@Max(1000)

	private int liters;
	private LocalDate RequestDate;
	private String status;
	
	/**
	 * Default constructor of Request class
	 * */
	public Request() {
		//Asignar ID
		//Registrar la fecha de la solicitud
		

	}

	/**
	 * Gets Request id
	 * @return int value with the Request id
	 * */
	public int getIdRequest() {
		return idRequest;
	}

	/**
	 * Sets Request id
	 * */
	public void setIdRequest() {
		this.idRequest = CONT_REQUEST;
		Request.CONT_REQUEST++;
	}
	
	/**
	 * Gets Request client id
	 * @return int value with the Request client id
	 * */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * Sets Request client id
	 * @param int value with the Request client id
	 * */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	/**
	 * Gets Request tank id
	 * @return int value with the Request tank id
	 * */
	public int getIdTank() {
		return idTank;
	}

	/**
	 * Sets Request tank id
	 * @param int value with the Request tank id
	 * */
	public void setIdTank(int idTank) {
		this.idTank = idTank;
	}
	
	/**
	 * Gets Request liters
	 * @return int value with the Request liters
	 * */
	public int getLiters() {
		return liters;
	}

	/**
	 * Sets Request liters
	 * @param int value with the Request liters
	 * */
	public void setLiters(int liters) {
		this.liters = liters;
	}

	/**
	 * Gets Request date
	 * @return Date value with the Request date
	 * */
	public LocalDate getRequestDate() {
		return RequestDate;
	}

	/**
	 * Sets Request date
	 * @param Date value with the Request date
	 * */
	public void setRequestDate() {
		this.RequestDate = java.time.LocalDate.now();
	}

	/**
	 * Gets Request status
	 * @return String value with the Request status
	 * */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets Request status
	 * @param String value with the Request status
	 * */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets Request info
	 * @return String value with the Request client info
	 * */
	@Override
	public String toString() {
		return "Request [idRequest=" + idRequest + ", idClient=" + idClient + ", idTank=" + idTank + ", liters="
				+ liters + ", RequestDate=" + RequestDate + ", status=" + status + "]";
	}
}
