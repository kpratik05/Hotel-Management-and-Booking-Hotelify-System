package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoleRepo;
import com.app.entities.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepo roleRepo;
	
	@Override
	public Role getFromId(int id) {
		
		return roleRepo.getFromId(id);
	}

}
