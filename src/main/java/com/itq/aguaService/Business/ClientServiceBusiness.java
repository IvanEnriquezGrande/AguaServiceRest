package com.itq.aguaService.Business;

import java.util.ArrayList;

import com.itq.aguaService.dto.Client;

public class ClientServiceBusiness {
	private static ArrayList<Client> clientes = new ArrayList<>();
	
	public static void addClient(Client client) {
		clientes.add(client);
	}
	
	public static int deleteClient(int id) {
		int index = clientes.indexOf(searchClient(id));
		if(index != -1) {
			int idClient = clientes.get(index).getIdClient();
			clientes.remove(index);
			return idClient;
		}
		return -1;
	}

	public static Client searchClient(int id) {
		for(Client c : clientes) {
			if(c.getIdClient() == id) {
				return c;
			}
		}
		return null;
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
