package com.app.services;

import java.util.List;

import com.app.dto.BookingDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Booking;
import com.app.entities.ShiftTable;
import com.app.entities.Staff;

public interface IStaffService {
	public StaffActualDTO getFromEmployeeId(int id);
	
	public Staff saveStaff(Staff staff);
	
	public Staff registerStaff(StaffDTO staffDTO);
	
	public List<Staff> getAllStaff();
	
	public boolean removeEmployee(int id);
	
	public Staff getStaffDetails(int id, String password);

	StaffActualDTO findUsingId(int id);

	Staff updateStaffDetails(StaffDTO s);

	public ShiftTable getShift(int id);

}
