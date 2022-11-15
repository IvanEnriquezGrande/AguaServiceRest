package com.itq.aguaService.endpoint;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.business.ClientServiceBusiness;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Client;
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
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			return client;
		}
		logger.info("Read solicitation, clientID: " + idCliente);
		return client;
	}
	
	@PostMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack createClient(@Valid@RequestBody Client cliente) {
		ClientServiceBusiness.addClient(cliente);
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Cliente creado, id" + cliente.getIdClient());
		logger.info("Client created:" + cliente.toString());
		return ack;
	}
	
	@DeleteMapping(value = "/client", produces = "application/json")
	public Ack deleteClient(@RequestParam(name="idCliente") int idCliente) {
		Ack ack = new Ack();
		int id = -1;
		try {
			id = ClientServiceBusiness.deleteClient(idCliente);
			logger.info("Client deleted, id: "+ idCliente);
		} catch (ObjectDeleteException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ack.setCode(205);
			ack.setDescription("Client not found");
			return ack;
		}
		ack.setCode(200);
		ack.setDescription("Client deleted, clientId:" + idCliente);
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
