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

import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Tank;

@RestController
public class TankServiceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@GetMapping("/tank")
	public Tank readTank(@RequestParam(name="idTank") int idTank) {
		// Funcionalidad leer
		Tank tank = new Tank();
		tank.setIdTank(idTank);
		tank.setNameTank("Centro");
		tank.setFillTime(100);
		tank.setCurrentContent(1000);
		tank.setSize(1000);
		tank.setState("LLenando");
		logger.info("Read solicitation");
		return tank;
	}
	
	@PostMapping(value = "/tank", consumes = "application/json", produces = "application/json")
	public Ack createTank(@Valid@RequestBody Tank tank) {
		// Funcionalidad crear
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Cliente creado, id" + tank.getIdTank());
		logger.info("Client created");
		return ack;
	}
	
	@PutMapping(value="/tank", consumes = "application/json", produces = "application/json")
	public Ack updateTank(@RequestParam(name="idTank") int idTank, @Valid@RequestBody Tank tank) {
		// Funcionalidad actualizar
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Tanque actualizado, id" + tank.getIdTank());
		logger.info("Tank updated");
		return ack;
	}
	
	@DeleteMapping(value="/tank")
	public Ack deleteTank(@RequestParam(name="idTank") int idTank) {
		// Funcionalidad eliminar
		Ack ack = new Ack();
		ack.setCode(200);
		ack.setDescription("Tanque eliminado, id" + idTank);
		logger.info("Tank deleted");
		return ack;
	}
}
