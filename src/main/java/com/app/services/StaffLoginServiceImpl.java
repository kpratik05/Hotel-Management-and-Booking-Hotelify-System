package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStaffLoginRepo;
import com.app.entities.StaffLogin;

@Service
@Transactional
public class StaffLoginServiceImpl implements IStaffLoginService{
	@Autowired
	private IStaffLoginRepo staffLoginRepo;

	@Override
	public List<StaffLogin> getAllStaffLogin() {
		// TODO Auto-generated method stub
		return staffLoginRepo.getStaffLogin();
	}

	@Override
	public List<StaffLogin> getStaffLoginFromDept(int dept) {
		// TODO Auto-generated method stub
		return staffLoginRepo.getStaffLoginFromDept(dept);
	}
	
	
}
