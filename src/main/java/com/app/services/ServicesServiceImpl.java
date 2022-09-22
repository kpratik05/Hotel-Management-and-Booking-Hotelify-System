package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IServicesRepo;
import com.app.entities.Services;

@Service
@Transactional
public class ServicesServiceImpl implements IServicesService {

	@Autowired
	private IServicesRepo serviceRepo;
	
	@Override
	public List<Services> getServices() {
		List<Services> services = serviceRepo.findAll();
		return services;
	}

	@Override
	public Services getServiceDetails(String serviceName) {
		Services serv = serviceRepo.getServiceDetails(serviceName);
		return serv;
	}

}
