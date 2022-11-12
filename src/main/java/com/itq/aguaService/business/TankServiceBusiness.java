package com.itq.aguaService.business;

import java.util.ArrayList;

import com.itq.aguaService.dto.Tank;
import com.itq.aguaService.exceptions.ObjectDeleteException;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

public class TankServiceBusiness {
	private static ArrayList<Tank> tanks = new ArrayList<>();
	
	public static void addTank(Tank tank) {
		tank.setIdTank();
		tanks.add(tank);
	}
	
	public static int deleteTank(int id) throws ObjectDeleteException {
		int index = -1;
		try {
			index = tanks.indexOf(searchTank(id));
			tanks.remove(index);
			int idTank = tanks.get(index).getIdTank();
			return idTank;
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			throw new ObjectDeleteException("Delete Error: " + e.getDescription());
		}
	}
	
	/*
	public static Tank updateTank(int idTank, Tank tank) throws ObjectNotFoundException {
		Tank tankUpdate = new Tank();

		try {
			tankUpdate = TankServiceBusiness.searchTank(idTank);
		} catch (Exception e) {
			throw new ObjectNotFoundException("ERROR: Client not found, Id: " + idTank);
		}
		
		if(tank.getNameTank() != null) {
			tankUpdate.setNameTank(tank.getNameTank());
		}
		
		if(tank.getFillTime() != null) {
			tankUpdate.setFillTime(tank.getFillTime());
		}
		
		if(tank.getCurrentContent() != null) {
			tankUpdate.setCurrentContent(tank.getCurrentContent());
		}
		
		if(tank.getSize() != null) {
			tankUpdate.setSize(tank.getSize());
		}
		
		if(tank.getState() != null) {
			tankUpdate.setState(tank.getState());
		}
		
		return tankUpdate;
	}
	*/
	public static Tank searchTank(int id) throws ObjectNotFoundException {
		for(Tank t : tanks) {
			if(t.getIdTank() == id) {
				return t;
			}
		}
		throw new ObjectNotFoundException("ERROR: Tank not found, Id: " + id);
	}
}
