package com.app.services;

import java.util.List;

import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Staff;

public interface IStaffService {
	public StaffActualDTO getFromEmployeeId(int id);
	
	public Staff saveStaff(Staff staff);
	
	public Staff registerStaff(StaffDTO staffDTO);
	
	public List<Staff> getAllStaff();
	
	public boolean removeEmployee(int id);
}
