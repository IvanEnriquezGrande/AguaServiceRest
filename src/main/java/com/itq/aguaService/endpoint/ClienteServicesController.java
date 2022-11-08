package com.itq.aguaService.endpoint;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Client;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@RestController
public class ClienteServicesController {
	
	private static ArrayList<Client> clientes = new ArrayList<>();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/client", produces = "application/json")
	public Client readClient(@RequestParam(name="idCliente") int idCliente) {
		Client client = searchClient(idCliente);
		logger.info("Read solicitation, clientID: " + idCliente);
		return client;
	}
	
	@PostMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack createClient(@Valid@RequestBody Client cliente) {
		clientes.add(cliente);
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Cliente creado, id" + cliente.getIdClient());
		logger.info("Client created");
		return ack;
	}
	
	@DeleteMapping(value = "/client", produces = "application/json")
	public Ack deleteClient(@RequestParam(name="idCliente") int idCliente) {
		int index;
		Ack ack = new Ack();
		index = searchClientAtArrayIndex(idCliente);
		if(index != -1) {
			int id = clientes.get(index).getIdClient();
			clientes.remove(index);
			ack.setCode(200);
			ack.setDescription("Client deleted, clientId:" + id);
		}
		else {
			ack.setCode(400);
			ack.setDescription("Client not found");
		}
		return ack;
	}
	
	private Client searchClient(int id) {
		for(Client c : clientes) {
			if(c.getIdClient() == id) {
				return c;
			}
		}
		return null;
	}
	
	private int searchClientAtArrayIndex(int id) {
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
