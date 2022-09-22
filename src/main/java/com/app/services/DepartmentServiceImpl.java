package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDepartmentRepo;
import com.app.entities.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepo departmentRepo;
	
	@Override
	public Department getFromId(int id) {
		
		return departmentRepo.getFromId(id);
	}

}
