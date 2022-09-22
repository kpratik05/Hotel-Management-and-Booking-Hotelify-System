package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminRepo;
import com.app.entities.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepo adminRepo;
	
	@Override
	public Admin adminVerification(int id, String password) {
		Admin admin = adminRepo.getAdminDetails(id, password);
		return admin;
	}

}
