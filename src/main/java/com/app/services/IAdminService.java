package com.app.services;

import java.util.List;

import com.app.dto.ManagerDTO;
import com.app.dto.RoomActualDTO;
import com.app.dto.RoomDTO;
import com.app.dto.ShiftTableDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Admin;
import com.app.entities.Manager;
import com.app.entities.Room;
import com.app.entities.ShiftTable;
import com.app.entities.Staff;

public interface IAdminService {
	public Admin adminVerification(int id,String password);
	
	public Admin adminDetails(int id);
	
	public Staff registerStaff(StaffDTO staffDTO);
	
	public Manager registerManager(ManagerDTO managerDTO);
	
	public RoomActualDTO getRoomInfo(int id);
	
	public ShiftTable getShiftInfo(int id);
	
	public Room addRoom(RoomDTO roomDTO);
	
	public Room updateRoom(RoomDTO roomDTO);
	
	public ShiftTable addShift(ShiftTableDTO shiftDTO);
	
	public ShiftTable updateShift(ShiftTableDTO shiftDTO);
	
	public List<Room> getRoomList();
	
	public List<ShiftTable> getShiftList();
	
	public boolean removeEmployee(int id);
	
	public List<Manager> getManagerList();
	
	public List<Staff> getStaffList();
}	
