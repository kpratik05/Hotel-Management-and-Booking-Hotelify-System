package com.app.services;

import java.util.List;

import com.app.entities.StaffLogin;

public interface IStaffLoginService {
	public List<StaffLogin> getAllStaffLogin();
	
	public List<StaffLogin> getStaffLoginFromDept(int dept);
}
