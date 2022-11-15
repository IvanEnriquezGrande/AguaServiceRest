package com.itq.aguaService.business;

import java.util.ArrayList;

import com.itq.aguaService.dto.Request;
import com.itq.aguaService.exceptions.ObjectNotFoundException;

public class RequestServiceBusiness {

	public static ArrayList<Request> requests = new ArrayList<>();

	public static Request searchRequest(int id) throws ObjectNotFoundException {
		for(Request request : requests) {
			if(request.getIdRequest() == id) {
				return request;
			}
		}
		throw new ObjectNotFoundException("ERROR: Request not found, Id: " + id);
	}
	
	public static Request updateRequest(int idRequest, Request request) throws ObjectNotFoundException {
		Request requestUpdate = new Request();
		try {
			requestUpdate = searchRequest(idRequest);
		}
		catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("ERROR: Request not found, Id: " + idRequest);
		}
		if(request.getIdTank() != 0) {
			requestUpdate.setIdTank(request.getIdTank());
		}
		if(request.getLiters() != 0 && requestUpdate.getLiters() != request.getLiters()) {
			requestUpdate.setLiters(request.getLiters());
		}
		if(request.getStatus() != null) {
			requestUpdate.setStatus(request.getStatus());
		}
		return requestUpdate;
	}
	
	public static void addRequest(Request request) {
		request.setIdRequest();
		request.setRequestDate();
		requests.add(request);
	}

}
