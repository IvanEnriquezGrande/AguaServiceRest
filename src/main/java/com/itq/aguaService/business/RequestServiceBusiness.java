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
	
	public static void addRequest(Request request) {
		request.setIdRequest();
		requests.add(request);
	}

}
