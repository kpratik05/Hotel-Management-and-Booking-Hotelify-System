package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStaffRepo;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Staff;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffRepo staffRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IShiftService shiftService;
	@Override
	public StaffActualDTO getFromEmployeeId(int id) {
		Staff staff = staffRepo.getFromId(id);
		if(staff!=null)
		{
			StaffActualDTO staffActual = mapper.map(staff, StaffActualDTO.class);
			return staffActual;
		}
		return null;
	}

	@Override
	public Staff saveStaff(Staff staff) {
		staffRepo.updateShift(staff.getShift(),staff.getEmployeeId());
		StaffActualDTO staffAfter  = getFromEmployeeId(staff.getEmployeeId());
		Staff staffE = mapper.map(staffAfter, Staff.class);
		Staff s = staffRepo.save(staffE);
		return s;
	}
	
	public Staff simpleSave(Staff staff)
	{
		return staffRepo.save(staff);
	}
	
	@Override
	public Staff registerStaff(StaffDTO staffDTO) {
		StaffActualDTO staffActual = new StaffActualDTO();
		staffActual.setAddress(staffDTO.getAddress());
		staffActual.setBirthDate(staffDTO.getBirthDate());
		staffActual.setDepartment(deptService.getFromId(staffDTO.getDepartment()));
		staffActual.setEmail(staffDTO.getEmail());
		staffActual.setMobileNo(staffDTO.getMobileNo());
		staffActual.setName(staffDTO.getName());
		staffActual.setPassword(staffDTO.getPassword());
		staffActual.setRole(roleService.getFromId(staffDTO.getRole()));
		staffActual.setShift(shiftService.getFromId(staffDTO.getShift()));
		Staff staff = mapper.map(staffActual, Staff.class);
		Staff s = simpleSave(staff);
		return s;
	}

	@Override
	public boolean removeEmployee(int id) {
		
		if(id==0)
		{
			return false;
		}
		
		staffRepo.deleteStaffFromId(id);
		
		StaffActualDTO staff = getFromEmployeeId(id);
		if(staff==null)
		{
			return true;
		}
		return false;
	}
	
	
}
