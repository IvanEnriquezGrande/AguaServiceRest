package com.itq.aguaService.dto;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;  

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Request {

	private static int CONT_REQUEST = 1;
	private static final SimpleDateFormat FORMATER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	private int idRequest;
	//@NotEmpty
	@NotNull
	private int idClient;
	private int idTank;
	@Min(1)
	@Max(1000)
	private int liters;
	private LocalDate RequestDate;
	private String status;
	
	public Request() {
		//Asignar ID
		this.idRequest = Request.CONT_REQUEST;
		Request.CONT_REQUEST++;
		//Registrar la fecha de la solicitud
		this.RequestDate = java.time.LocalDate.now();

	}

	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest() {
		this.idRequest = CONT_REQUEST;
		Request.CONT_REQUEST++;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdTank() {
		return idTank;
	}

	public void setIdTank(int idTank) {
		this.idTank = idTank;
	}

	public int getLiters() {
		return liters;
	}

	public void setLiters(int liters) {
		this.liters = liters;
	}

	public LocalDate getRequestDate() {
		return RequestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		RequestDate = requestDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [idRequest=" + idRequest + ", idClient=" + idClient + ", idTank=" + idTank + ", liters="
				+ liters + ", RequestDate=" + RequestDate + ", status=" + status + "]";
	}
}
