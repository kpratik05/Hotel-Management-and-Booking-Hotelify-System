package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IManagerRepo;
import com.app.dto.ManagerActualDTO;
import com.app.dto.ManagerDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Manager;
import com.app.entities.Staff;

@Service
@Transactional
public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private IManagerRepo managerRepo;
	@Autowired
	private IStaffService staffService;
	@Autowired
	private IShiftService shiftService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IDepartmentService deptService;
	@Override
	public Manager managerVerification(int id, String password) {
		Manager manager = managerRepo.findByIdAndPassword(id,password);
		return manager;
	}
	@Override
	public ManagerActualDTO findUsingId(int id) {
		// TODO Auto-generated method stub
		Manager manager = managerRepo.getFromId(id);
		ManagerActualDTO managerDTO = mapper.map(manager, ManagerActualDTO.class);
		return managerDTO;
	}
	@Override
	public boolean updateManagerDetails(ManagerDTO managerDTO) {
		ManagerActualDTO managerActual = findUsingId(managerDTO.getEmployeeId());
		managerActual.setDepartment(deptService.getFromId(managerDTO.getDepartment()));
		Manager manager = mapper.map(managerActual, Manager.class);
		Manager managerAfter = managerRepo.save(manager);
		if(managerAfter!=null)
		{
			return true;
		}
		return false;
	}
	@Override
	public List<Staff> getEmployeesInDepartment(int deptNo) {
		List<Staff> staffList = managerRepo.getEmployeesInDepartment(deptNo); 
		return staffList;
	}
	@Override
	public StaffActualDTO getEmployeeDetails(int employeeId) {
		StaffActualDTO staff = (StaffActualDTO) staffService.getFromEmployeeId(employeeId);
		
		return staff;
	}
	
	@Override
	public StaffActualDTO assignShift(StaffDTO staffDTO)
	{
		StaffActualDTO staffActual = staffService.getFromEmployeeId(staffDTO.getEmployeeId());
		staffActual.setShift(shiftService.getFromId(staffDTO.getShift()));
		staffActual.setRole(roleService.getFromId(staffDTO.getRole().getRoleId()));
		staffActual.setDepartment(deptService.getFromId(staffDTO.getDepartment()));
		Staff staff = mapper.map(staffActual, Staff.class);
		
		Staff s = staffService.saveStaff(staff);
		StaffActualDTO staffAc = mapper.map(s, StaffActualDTO.class);
		return staffAc;
	}
	
	
	
}
