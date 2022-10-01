package com.app.services;

import java.time.LocalTime;
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
import com.app.dto.StaffFeedbackActualDTO;
import com.app.dto.StaffFeedbackDTO;
import com.app.entities.Manager;
import com.app.entities.ManagerLogin;
import com.app.entities.Payment;
import com.app.entities.Staff;
import com.app.entities.StaffFeedback;
import com.app.entities.StaffLogin;

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
	private IStaffFeedbackService staffFeedbackService;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IStaffLoginService staffLoginService;
	@Autowired
	private IManagerLoginService managerLoginService;
	@Autowired
	private IManagerLoginService manLoginService;
	@Override
	public Manager managerVerification(int id, String password) {
		Manager manager = managerRepo.findByIdAndPassword(id,password);
		ManagerLogin manLog = new ManagerLogin();
		manLog.setManager(manager);
		manLog.setDate(java.time.LocalDate.now());
		manLog.setLoginTime(java.sql.Time.valueOf(LocalTime.now()));
		manLoginService.loginEntry(manLog);
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
	public Manager updateManagerDetails(ManagerActualDTO managerDTO) {
		
		Manager manager = mapper.map(managerDTO, Manager.class);
		Manager managerAfter = managerRepo.save(manager);
		return managerAfter;
	}
	@Override
	public List<Staff> getEmployeesInDepartment(int deptNo) {
		List<Staff> staffList = managerRepo.getEmployeesInDepartment(deptNo); 
		return staffList;
	}
	@Override
	public StaffActualDTO getEmployeeDetails(int employeeId) {
		StaffActualDTO staff = staffService.getFromEmployeeId(employeeId);
		
		return staff;
	}
	
	@Override
	public Staff assignShift(StaffDTO staffDTO)
	{
		StaffActualDTO staffActual = staffService.getFromEmployeeId(staffDTO.getEmployeeId());
		staffActual.setShift(shiftService.getFromId(staffDTO.getShift()));
		Staff staffEnt = mapper.map(staffActual, Staff.class);
		System.out.println("Staff in managerserviceimpl "+staffEnt.getEmail()+" "+staffEnt.getPassword()+" "+staffEnt.getDepartment().getDeptName());
		Staff s = staffService.saveStaff(staffEnt);
		return s;
	}
	@Override
	public List<StaffFeedback> getEmployeeFeedback(int dept) {
		List<StaffFeedback> staffFeedback = staffFeedbackService.getFeedbackFromDept(dept);
		return staffFeedback ;
	}
	@Override
	public StaffFeedback addFeedback(StaffFeedbackDTO feedbackDTO) {
		StaffFeedbackActualDTO feedbackActual = new StaffFeedbackActualDTO();
		Staff staff = mapper.map(staffService.getFromEmployeeId(feedbackDTO.getStaff()),Staff.class); 
		feedbackActual.setStaff(staff);
		feedbackActual.setDate(feedbackDTO.getDate());
		feedbackActual.setFeedback(feedbackDTO.getFeedback());
		
		return staffFeedbackService.saveFeedback(mapper.map(feedbackActual, StaffFeedback.class));
	}
	@Override
	public StaffFeedback getEmployeeFeedbackFromId(int id) {
		// TODO Auto-generated method stub
		return staffFeedbackService.getFeedbackFromId(id);
	}
	@Override
	public List<StaffFeedback> getFeedbackFromEmployeeId(int id) {
		// TODO Auto-generated method stub
		return staffFeedbackService.getFeedbackFromEmployeeId(id);
	}
	@Override
	public List<Payment> getPaymentList() {
		
		return paymentService.getPaymentList();
	}
	
	@Override
	public List<StaffLogin> getStaffLoginFromDept(int dept) {
		// TODO Auto-generated method stub
		return staffLoginService.getStaffLoginFromDept(dept);
	}
	@Override
	public List<ManagerLogin> getManagerLogin(int id) {
		// TODO Auto-generated method stub
		return managerLoginService.getManagerLogin(id);
	}
	@Override
	public Manager resisterManager(ManagerDTO managerDTO) {
		ManagerActualDTO managerActual = new ManagerActualDTO();
		managerActual.setAddress(managerDTO.getAddress());
		managerActual.setBirthDate(managerDTO.getBirthDate());
		managerActual.setDepartment(deptService.getFromId(managerDTO.getDepartment()));
		managerActual.setEmail(managerDTO.getEmail());
		managerActual.setMobileNo(managerDTO.getMobileNo());
		managerActual.setName(managerDTO.getName());
		managerActual.setPassword(managerDTO.getPassword());
		Manager manager = mapper.map(managerActual, Manager.class);
		return managerRepo.save(manager);
	}
	@Override
	public List<Manager> getManagerList() {
		// TODO Auto-generated method stub
		return managerRepo.getList();
	}
	
	
	
}
