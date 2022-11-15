package com.itq.aguaService.endpoint;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
public class TankServicesController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@GetMapping("/tank")
	public Tank readTank(@RequestParam(name="idTank") int idTank) {
		// Funcionalidad leer
		Tank tank = new Tank();
		try {
			tank = TankServiceBusiness.searchTank(idTank);
		} catch (ObjectNotFoundException e) {
			logger.error(e.getDescription());
			return tank;
		}
		
		logger.info("Read solicitation, tankID: " + idTank);
		return tank;
	}
	
	@PostMapping(value = "/tank", consumes = "application/json", produces = "application/json")
	public Ack createTank(@Valid@RequestBody Tank tank) {
		// Funcionalidad crear
		TankServiceBusiness.addTank(tank);
		
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Tanque creado, id: " + tank.getIdTank());
		
		logger.info("Tank created");
		return ack;
	}
	
	
	@DeleteMapping(value="/tank")
	public Ack deleteTank(@RequestParam(name="idTank") int idTank) {
		// Funcionalidad eliminar
		Ack ack = new Ack();
		int id = -1;
		try {
			id = TankServiceBusiness.deleteTank(idTank);
		} catch (ObjectDeleteException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ack.setCode(400);
			ack.setDescription("Tank not found.");
			return ack;
		}
		
		ack.setCode(200);
		ack.setDescription("Tank deleted, id" + id);
		logger.info("Tank deleted");
		return ack;
	}
}
