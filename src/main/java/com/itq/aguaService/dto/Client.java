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
	
	/**
	 * Default constructor of Client class
	 * */
	public Client() {
		
	}

	public Client(int option) {
		
	}
	
	/**
	 * Gets Client name
	 * @return String value with the Client name
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets Client name
	 * @param String value with the Client name
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets Client id
	 * @return int value with the Client id
	 * */
	public int getIdClient() {
		return idClient;
	}
	
	/**
	 * Sets Client id
	 * */
	public void setIdClient() {
		this.idClient = CONT_CLIENTS;
		Client.CONT_CLIENTS++;
	}
	
	/**
	 * Gets Client lastname
	 * @return String value with the Client lastname
	 * */
	public String getLastName1() {
		return lastName1;
	}
	
	/**
	 * Sets Client lastname
	 * @param String value with the Client lastname
	 * */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	
	/**
	 * Gets second Client lastname in case of have two of them
	 * @return String value with the Client lastname
	 * */
	public String getLastName2() {
		return lastName2;
	}
	
	/**
	 * Sets second Client lastname in case of have two of them
	 * @param String value with the Client lastname
	 * */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	
	/**
	 * Gets Client zone
	 * @return int value with the Client zone
	 * */
	public int getZone() {
		return zone;
	}
	
	/**
	 * Sets Client zone
	 * @param int value with the Client zone
	 * */
	public void setZone(int zone) {
		this.zone = zone;
	}
	
	/**
	 * Gets Client phone number
	 * @return String value with the Client phone number
	 * */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets Client phone number
	 * @param String value with the Client phone number
	 * */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets Client email
	 * @return String value with the Client email
	 * */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets Client email
	 * @param String value with the Client email
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets Client street
	 * @return String value with the Client street
	 * */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets Client street
	 * @param String value with the Client street
	 * */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets Client colonia
	 * @return String value with the Client colonia
	 * */
	public String getColonia() {
		return colonia;
	}
	
	/**
	 * Sets Client colonia
	 * @param String value with the Client colonia
	 * */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Gets Client postal code
	 * @return String value with the Client postal code
	 * */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Sets Client postal code
	 * @param String value with the Client postal code
	 * */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Gets Client city
	 * @return String value with the Client city
	 * */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets Client city
	 * @param String value with the Client city
	 * */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets Client info
	 * @return String value with the Client info
	 * */
	@Override
	public String toString() {
		return "Client [name=" + name + ", idClient=" + idClient + ", lastName1=" + lastName1 + ", lastName2="
				+ lastName2 + ", zone=" + zone + ", phoneNumber=" + phoneNumber + ", email=" + email + ", street="
				+ street + ", colonia=" + colonia + ", postalCode=" + postalCode + ", city=" + city + "]";
	}
}
