package com.app.services;

import java.util.List;
import com.app.entities.Services;

public interface IServicesService {
	public List<Services> getServices();
	
	public Services getServiceDetails(String serviceName);
}	
