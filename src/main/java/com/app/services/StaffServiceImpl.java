package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerRepo;
import com.app.dao.IShiftTableRepo;
import com.app.dao.IStaffRepo;
import com.app.dto.BookingDTO;
import com.app.dto.CustomerDTO;
import com.app.dto.EmployeeActualDTO;
import com.app.dto.EmployeeDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Booking;
import com.app.entities.Customer;
import com.app.entities.Employee;
import com.app.entities.ShiftTable;
import com.app.entities.Staff;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffRepo staffRepo;
	
	/*
	 * @Autowired private IStaffService staffService;
	 */
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IShiftService shiftService;
	
	@Autowired
	private IShiftTableRepo shiftRepo;
	
	@Autowired 
	ICustomerService customerService;
	
	 @Autowired
	 IStaffLoginService staffLogin;
	 
	 @Autowired
	 ICustomerRepo custRepo;
	
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

	@Override
	public Staff getStaffDetails(int id, String password) {
		Staff staff = staffRepo.findByIdAndPassword(id,password);
		return staff;
	}
	
	@Override
	public StaffActualDTO findUsingId(int id) {
		// TODO Auto-generated method stub
		Staff staff = staffRepo.getFromId(id);
		StaffActualDTO staffDTO = mapper.map(staff, StaffActualDTO.class);
		return staffDTO;
	}

	@Override
	public Staff updateStaffDetails(StaffDTO s) {
		StaffActualDTO staffActual = findUsingId(s.getEmployeeId());
		
		staffActual.setAddress(s.getAddress());
		staffActual.setBirthDate(s.getBirthDate());
		staffActual.setEmail(s.getEmail());
		staffActual.setMobileNo(s.getMobileNo());
		staffActual.setName(s.getName());
		staffActual.setPassword(s.getPassword());
		Staff staff = mapper.map(staffActual, Staff.class);
		Staff staffAfter = staffRepo.save(staff);
		return staffAfter;
	
	}

	@Override
	public ShiftTable getShift(int id) {
		return shiftRepo.getShift(id);
	}


	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return staffRepo.getStaffList();
	}
}
