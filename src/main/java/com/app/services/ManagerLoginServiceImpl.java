package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IManagerLoginRepo;
import com.app.entities.ManagerLogin;

@Service
@Transactional
public class ManagerLoginServiceImpl implements IManagerLoginService {
	
	@Autowired
	private IManagerLoginRepo managerLoginRepo;
	
	@Override
	public List<ManagerLogin> getAllLogin() {
		// TODO Auto-generated method stub
		return managerLoginRepo.getAllLogin();
	}

	@Override
	public List<ManagerLogin> getManagerLogin(int id) {
		// TODO Auto-generated method stub
		return managerLoginRepo.getLoginManager(id);
	}

}
