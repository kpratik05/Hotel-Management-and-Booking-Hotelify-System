package com.app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStatusRepo;
import com.app.entities.Status;

@Service
@Transactional
public class StatusServiceImpl implements IStatusService {

	
	@Autowired
	private IStatusRepo statusRepo;
	
	public Status getFromId(int id)
	{
		return statusRepo.getFromId(id);
	}
}
