package com.app.services;

import java.util.List;

import com.app.dto.ManagerActualDTO;
import com.app.dto.ManagerDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Manager;
import com.app.entities.Staff;

public interface IManagerService {
	public Manager managerVerification(int id,String password);
	
	public ManagerActualDTO findUsingId(int id);
	
	public boolean updateManagerDetails(ManagerDTO manager);
	
	public List<Staff> getEmployeesInDepartment(int deptNo);
	
	public StaffActualDTO getEmployeeDetails(int employeeId);
	
	public StaffActualDTO assignShift(StaffDTO staffDTO);
	
}
