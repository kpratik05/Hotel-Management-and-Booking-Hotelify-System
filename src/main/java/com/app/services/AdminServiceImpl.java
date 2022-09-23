package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminRepo;
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

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepo adminRepo;
	@Autowired
	private IStaffService staffService;
	@Autowired
	private IManagerService managerService;
	@Autowired
	private IRoomService roomService;
	@Autowired
	private IShiftService shiftService;
	@Override
	public Admin adminVerification(int id, String password) {
		Admin admin = adminRepo.getAdminDetails(id, password);
		return admin;
	}

	@Override
	public Staff registerStaff(StaffDTO staffDTO) {
		// TODO Auto-generated method stub
		return staffService.registerStaff(staffDTO);
	}

	@Override
	public Manager registerManager(ManagerDTO managerDTO) {
		// TODO Auto-generated method stub
		return managerService.resisterManager(managerDTO);
	}

	@Override
	public Room addRoom(RoomDTO roomDTO) {
		
		return roomService.addRoom(roomDTO);
	}

	@Override
	public Room updateRoom(RoomDTO roomDTO) {
		// TODO Auto-generated method stub
		return roomService.updateRoom(roomDTO);
	}

	@Override
	public ShiftTable addShift(ShiftTableDTO shiftDTO) {
		// TODO Auto-generated method stub
		return shiftService.addShift(shiftDTO);
	}

	@Override
	public ShiftTable updateShift(ShiftTableDTO shiftDTO) {
		// TODO Auto-generated method stub
		System.out.println(shiftDTO);
		return shiftService.updateShift(shiftDTO);
	}

	@Override
	public RoomActualDTO getRoomInfo(int id) {
		// TODO Auto-generated method stub
		return roomService.getRoomInfo(id);
	}

	@Override
	public ShiftTable getShiftInfo(int id) {
		// TODO Auto-generated method stub
		return shiftService.getFromId(id);
	}

	@Override
	public List<Room> getRoomList() {
		// TODO Auto-generated method stub
		return roomService.getAllRooms();
	}

	@Override
	public List<ShiftTable> getShiftList() {
		// TODO Auto-generated method stub
		return shiftService.getShiftList();
	}

	@Override
	public boolean removeEmployee(int id) {
		// TODO Auto-generated method stub
		return staffService.removeEmployee(id);
	}
	
	
	
}
