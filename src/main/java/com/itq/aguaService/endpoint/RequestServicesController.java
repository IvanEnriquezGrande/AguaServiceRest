package com.itq.aguaService.endpoint;

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
		try {
			request = RequestServiceBusiness.searchRequest(idRequest);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			return request;
		}
		logger.info("Read solicitation, requestID: " + idRequest);
		return request;
	}
	
	@PostMapping(value = "/request", consumes = "application/json", produces = "application/json")
	public Ack createRequest(@Valid@RequestBody Request request) {
		RequestServiceBusiness.addRequest(request);
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Request creado, id" + request.getIdRequest());
		logger.info("Request created");
		return ack;
	}
	
	@PutMapping(value = "/request", consumes = "application/json", produces = "application/json")
	public Ack updateClient(@RequestParam(name="idRequest") int idRequest,@RequestBody Request request) {
		Ack ack = new Ack();
		Request requestUpdate = new Request();
		try {
			requestUpdate = RequestServiceBusiness.updateRequest(idRequest, request);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			ack.setCode(400);
			ack.setDescription("Error request not found: " + idRequest);
		}
		ack.setCode(200);
		ack.setDescription(requestUpdate.toString());
		return ack;
	}

}