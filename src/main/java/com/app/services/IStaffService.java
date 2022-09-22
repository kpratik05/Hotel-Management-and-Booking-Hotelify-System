package com.app.services;

import com.app.dto.StaffActualDTO;
import com.app.entities.Staff;

public interface IStaffService {
	public StaffActualDTO getFromEmployeeId(int id);
	
	public Staff saveStaff(Staff staff);
	
}
