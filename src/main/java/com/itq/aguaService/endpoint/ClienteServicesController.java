package com.itq.aguaService.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Client;

@RestController
public class ClienteServicesController {
	
	@GetMapping("/client")
	public Client readClient(@RequestParam(name="idCliente") String idCliente) {
		
		return new Client();
	}
	
	@PostMapping(value = "/client", consumes = "application/json", produces = "application/json")
	public Ack createClient(@RequestBody Client cliente) {
		
		return new Ack();
	}
}
