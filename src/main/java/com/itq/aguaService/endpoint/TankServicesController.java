package com.itq.aguaService.endpoint;

import java.util.ArrayList;

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
		
	/**
	 * Send a t by tankd
	 * @param int idTank to get information
	 * @return Tank the tank properties
	 * */
	@GetMapping("/tank")
	public Tank readTank(@RequestParam(name="idTank") int idTank) {
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
	
	/**
	 * Send a tank index
	 * @return Ack with the description and list of tanks
	 * */
	@GetMapping(value = "/tank/index", produces = "application/json")
	public Ack indexTank() {
		logger.info("Peticion de todos los tanques");
		Ack ack = new Ack();
		ack.setCode(200);
		String description = "Tanks number: " + TankServiceBusiness.getNTanks();
		ArrayList<Tank> tanks = TankServiceBusiness.getTanks();
		String lista = "";
		for(Tank tank : tanks) {
			lista+=tank.toString()+"; ";
		}
		ack.setExtra(lista);
		ack.setDescription(description);
		return ack;
	}
	
	/**
	 * Create a tank
	 * @param Tank the valid values
	 * @return Ack return the status of the new tank
	 * */
	@PostMapping(value = "/tank", consumes = "application/json", produces = "application/json")
	public Ack createTank(@Valid@RequestBody Tank tank) {
		TankServiceBusiness.addTank(tank);
		logger.info("Tank created: " + tank.toString());
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Tanque creado, id: " + tank.getIdTank());
		return ack;
	}
	
	/**
	 * Delete a tank by id
	 * @param int idTank to delete
	 * @return Ack with the delete status
	 * */
	@DeleteMapping(value="/tank")
	public Ack deleteTank(@RequestParam(name="idTank") int idTank) {
		// Funcionalidad eliminar
		Ack ack = new Ack();
		Tank tank = new Tank();
		int id = -1;
		try {
			tank = TankServiceBusiness.deleteTank(idTank);
			logger.info("TANK DELETED " + tank.toString());
		} catch (ObjectDeleteException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			ack.setCode(205);
			ack.setDescription("Tank not found.");
			return ack;
		}
		
		ack.setCode(200);
		ack.setDescription("Tank deleted, id" + id);
		return ack;
	}
}
