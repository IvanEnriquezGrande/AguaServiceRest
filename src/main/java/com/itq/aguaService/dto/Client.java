package com.itq.aguaService.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Client {

	private static int CONT_CLIENTS = 1;
	
	@NotEmpty
	@NotNull
	private String name;
	private int idClient;
	@NotEmpty
	@NotNull
	private String lastName1;
	@NotNull
	private String lastName2;
	private int zone;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String email;
	
	//Direccion
	@NotEmpty
	@NotNull
	private String street;
	@NotEmpty
	@NotNull
	private String colonia;
	@NotEmpty
	@NotNull
	private String postalCode;
	@NotEmpty
	@NotNull
	private String city;
	
	public Client() {
		this.idClient = CONT_CLIENTS;
		Client.CONT_CLIENTS++;
	}

	public Client(int option) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", idClient=" + idClient + ", lastName1=" + lastName1 + ", lastName2="
				+ lastName2 + ", zone=" + zone + ", phoneNumber=" + phoneNumber + ", email=" + email + ", street="
				+ street + ", colonia=" + colonia + ", postalCode=" + postalCode + ", city=" + city + "]";
	}
}
