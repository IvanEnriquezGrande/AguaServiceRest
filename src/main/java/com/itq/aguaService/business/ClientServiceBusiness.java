package com.itq.aguaService.business;

import java.util.ArrayList;

import com.itq.aguaService.dto.Client;
import com.itq.aguaService.exceptions.ObjectDeleteException;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

public class ClientServiceBusiness {
	private static ArrayList<Client> clientes = new ArrayList<>();
	
	public static void addClient(Client client) {
		client.setIdClient();
		clientes.add(client);
	}
	
	public static int deleteClient(int id) throws ObjectDeleteException {
		int index = -1;
		try {
			index = clientes.indexOf(searchClient(id));
			clientes.remove(index);
			int idClient = clientes.get(index).getIdClient();
			return idClient;
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			throw new ObjectDeleteException("Delete Error: " + e.getDescription());
		}
	}
	
	public static Client updateClient(int idClient, Client client) throws ObjectNotFoundException {
		Client clientUpdate = new Client();

		try {
			clientUpdate = ClientServiceBusiness.searchClient(idClient);
		} catch (Exception e) {
			throw new ObjectNotFoundException("ERROR: Client not found, Id: " + idClient);
		}

		if(client.getName() != null) {
			clientUpdate.setName(client.getName());
		}
		
		if(client.getLastName1() != null) {
			clientUpdate.setLastName1(client.getLastName1());
		}
		
		if(client.getLastName2() != null) {
			clientUpdate.setLastName2(client.getLastName2());
		}
		
		if(client.getPhoneNumber() != null) {
			clientUpdate.setPhoneNumber(client.getPhoneNumber());
		}
		
		if(client.getEmail() != null) {
			clientUpdate.setEmail(client.getEmail());
		}
		
		if(client.getPostalCode() != null) {
			clientUpdate.setPostalCode(client.getPostalCode());
		}
		
		if(client.getCity() != null) {
			clientUpdate.setCity(client.getCity());
		}
		
		if(client.getColonia() != null) {
			clientUpdate.setColonia(client.getColonia());
		}
		
		if(client.getStreet() != null) {
			clientUpdate.setStreet(client.getStreet());
		}
		
		return clientUpdate;
	}

	public static Client searchClient(int id) throws ObjectNotFoundException {
		for(Client c : clientes) {
			if(c.getIdClient() == id) {
				return c;
			}
		}
		throw new ObjectNotFoundException("ERROR: Client not found, Id: " + id);
	}
}
