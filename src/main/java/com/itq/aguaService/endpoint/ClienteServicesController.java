package com.itq.aguaService.endpoint;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.business.ClientServiceBusiness;
import com.itq.aguaService.business.TankServiceBusiness;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Client;
import com.itq.aguaService.dto.Tank;
import com.itq.aguaService.exceptions.ObjectDeleteException;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@RestController
public class ClienteServicesController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(value = "/client", produces = "application/json")
	public Client readClient(@RequestParam(name="idCliente") int idCliente) {
		Client client = new Client(1);
		try {
			client = ClientServiceBusiness.searchClient(idCliente);
			logger.info("Read solicitation, clientID: " + idCliente);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			return client;
		}
		return client;
	}
	
	@GetMapping(value = "/client/index", produces = "application/json")
	public Ack indexClient() {
		logger.info("Peticion de todos los clientes");
		Ack ack = new Ack();
		ack.setCode(200);
		String description = "Clients number: " + ClientServiceBusiness.getNClients();
		ArrayList<Client> clients = ClientServiceBusiness.getClients();
		String lista = "";
		for(Client client : clients) {
			lista+=client.toString()+"; ";
		}
		ack.setExtra(lista);
		ack.setDescription(description);
		return ack;
	}
	
	@PostMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack createClient(@Valid@RequestBody Client cliente) {
		ClientServiceBusiness.addClient(cliente);
		logger.info("Client created:" + cliente.toString());
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Cliente creado, id" + cliente.getIdClient());
		return ack;
	}
	
	@DeleteMapping(value = "/client", produces = "application/json")
	public Ack deleteClient(@RequestParam(name="idCliente") int idCliente) {
		Ack ack = new Ack();
		Client client = new Client();
		try {
			client = ClientServiceBusiness.deleteClient(idCliente);
			logger.info("Client deleted, id: "+ idCliente);
		} catch (ObjectDeleteException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ack.setCode(205);
			ack.setDescription("Client not found, ID: " + idCliente);
			return ack;
		}
		ack.setCode(200);
		ack.setDescription("Client deleted " + client.toString());
		return ack;
	}
	
	@PutMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack updateClient(@RequestParam(name="idClient") int idClient,@RequestBody Client client) {
		Ack ack = new Ack();
		Client clientUpdate = new Client();
		try {
			clientUpdate = ClientServiceBusiness.updateClient(idClient, client);
			logger.info("Client updated, id: " + idClient);
		} catch (ObjectNotFoundException e) {
			//e.printStackTrace();
			logger.error(e.getDescription());
			ack.setCode(205);
			ack.setDescription("Client not found: " + idClient);
			return ack;
		}
		ack.setCode(200);
		ack.setDescription(clientUpdate.toString());
		return ack;
	}
}
