package com.itq.aguaService.endpoint;

import javax.validation.Valid;

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
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/client")
	public Client readClient(@RequestParam(name="idCliente") String idCliente) {
		Client cliente = new Client();
		cliente.setLastName1("Primero");
		cliente.setName("Prueba");
		cliente.setEmail("prueba@gmail.com");
		cliente.setPhoneNumber("1234556");
		cliente.setZone(1);
		cliente.setCity("Queretaro");
		logger.info("Read solicitation");
		return cliente;
	}
	
	@PostMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack createClient(@Valid@RequestBody Client cliente) {
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Cliente creado, id" + cliente.getIdClient());
		logger.info("Client created");
		return ack;
	}
}
