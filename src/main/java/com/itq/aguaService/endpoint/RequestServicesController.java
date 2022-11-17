package com.itq.aguaService.endpoint;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.business.ClientServiceBusiness;
import com.itq.aguaService.business.RequestServiceBusiness;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Client;
import com.itq.aguaService.dto.Request;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

@RestController
public class RequestServicesController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/request")
	public Request readRequest(@RequestParam(name = "idRequest") int idRequest) {
		Request request = new Request();
		logger.info("Read solicitation, requestID: " + idRequest);
		try {
			request = RequestServiceBusiness.searchRequest(idRequest);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			return request;
		}
		return request;
	}
	
	@GetMapping(value = "/request/index", produces = "application/json")
	public Ack indexRequest() {
		logger.info("Peticion de todos los request");
		Ack ack = new Ack();
		ack.setCode(200);
		String description = "Request number: " + RequestServiceBusiness.getNRequest();
		ArrayList<Request> requests = RequestServiceBusiness.getRequest();
		String lista = "";
		for(Request request : requests) {
			lista+=request.toString()+"; ";
		}
		ack.setExtra(lista);
		ack.setDescription(description);
		return ack;
	}
	
	@PostMapping(value = "/request", consumes = "application/json", produces = "application/json")
	public Ack createRequest(@Valid @RequestBody Request request) {
		logger.info("Request created" + request.toString());
		RequestServiceBusiness.addRequest(request);
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Request creado, id" + request.getIdRequest());
		return ack;
	}
	
	@PutMapping(value = "/request", consumes = "application/json", produces = "application/json")
	public Ack updateClient(@RequestParam(name="idRequest") int idRequest,@RequestBody Request request) {
		Ack ack = new Ack();
		Request requestUpdate = new Request();
		logger.info("Update client/:"  + request.toString());
		try {
			requestUpdate = RequestServiceBusiness.updateRequest(idRequest, request);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			ack.setCode(205);
			ack.setDescription("Error request not found: " + idRequest);
		}
		ack.setCode(200);
		ack.setDescription(requestUpdate.toString());
		return ack;
	}

}