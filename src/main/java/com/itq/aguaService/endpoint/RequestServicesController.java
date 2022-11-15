package com.itq.aguaService.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itq.aguaService.business.RequestServiceBusiness;
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

}
