package com.app.services;

import java.util.List;

import com.app.dto.ManagerActualDTO;
import com.app.dto.ManagerDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.dto.StaffFeedbackDTO;
import com.app.entities.Manager;
import com.app.entities.ManagerLogin;
import com.app.entities.Payment;
import com.app.entities.Staff;
import com.app.entities.StaffFeedback;
import com.app.entities.StaffLogin;

public interface IManagerService {
	public Manager managerVerification(int id,String password);
	
	public ManagerActualDTO findUsingId(int id);
	
	public Manager updateManagerDetails(ManagerActualDTO manager);
	
	public List<Staff> getEmployeesInDepartment(int deptNo);
	
	public StaffActualDTO getEmployeeDetails(int employeeId);
	
	public Staff assignShift(StaffDTO staffDTO);

	public List<StaffFeedback> getEmployeeFeedback(int dept);
	
	public StaffFeedback addFeedback(StaffFeedbackDTO feedbackSTO);
	
	public StaffFeedback getEmployeeFeedbackFromId(int id);
	
	public List<StaffFeedback>  getFeedbackFromEmployeeId(int id);
	
	public List<Payment> getPaymentList();
	
	public List<Manager> getManagerList();
	
	public List<StaffLogin> getStaffLoginFromDept(int dept);
	
	public List<ManagerLogin> getManagerLogin(int id);
	
	public Manager resisterManager(ManagerDTO managerDTO);
}
