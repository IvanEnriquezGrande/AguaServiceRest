package com.itq.aguaService.business;

import java.util.ArrayList;

import com.itq.aguaService.dto.Client;
import com.itq.aguaService.exceptions.ObjectDeleteException;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

public class ClientServiceBusiness {
	private static ArrayList<Client> clientes = new ArrayList<>();
	
	public static void addClient(Client client) {
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

	public static Client searchClient(int id) throws ObjectNotFoundException {
		for(Client c : clientes) {
			if(c.getIdClient() == id) {
				return c;
			}
		}
		throw new ObjectNotFoundException("ERROR: Client not found, Id: " + id);
	}
	
	private static int searchClientAtArrayIndex(int id) {
		int index = 0;
		for(Client client : clientes) {
			if(client.getIdClient() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
