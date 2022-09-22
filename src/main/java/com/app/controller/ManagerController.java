package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.EmployeeLoginInfoDTO;
import com.app.dto.ManagerDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Manager;
import com.app.entities.Staff;
import com.app.services.IManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private IManagerService managerService;
	
	 @GetMapping("/login")
	 public ResponseEntity<?> getManagerLogin()
	 {
		 return ResponseEntity.ok("Enter manager ID and password");
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<?> getManagerDetails(@RequestBody EmployeeLoginInfoDTO loginInfo,HttpSession session)
	 {
		 System.out.println(loginInfo.getId()+" "+loginInfo.getPassword());
		 Manager manager = managerService.managerVerification(loginInfo.getId(), loginInfo.getPassword());
		 session.setAttribute("user", manager);
		 return new  ResponseEntity<>(manager,HttpStatus.OK);
	 }
	 
	 @GetMapping("/profile")
	 public ResponseEntity<?> getProfile(HttpSession session)
	 {
		 return new ResponseEntity<>(session.getAttribute("user"),HttpStatus.OK);
	 }
	 
	 @GetMapping("/update")
	 public ResponseEntity<?> updateManagerInfo(HttpSession session)
	 {
		 Manager manager = (Manager) session.getAttribute("user");
		 System.out.println("Manager = "+manager.getEmail());
		 return ResponseEntity.ok(session.getAttribute("user"));
	 }
	 
	 @PostMapping("/update")
	 public ResponseEntity<?> updateManager(@RequestBody ManagerDTO manager,HttpSession session)
	 {
		 managerService.updateManagerDetails(manager);
		 session.setAttribute("user", manager);
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Location", "/manager/profile");
	     return new ResponseEntity<>(headers, HttpStatus. OK);
	 }
	 
	 @GetMapping("/stafflist")
	 public ResponseEntity<?> getEmployeesFromDepartment(HttpSession session)
	 {
		 Manager manager = (Manager) session.getAttribute("user");
		 int deptId = manager.getDepartment().getDeptId();
		 List<Staff> staffList =managerService.getEmployeesInDepartment(deptId);
		 return new ResponseEntity<>(staffList,HttpStatus.OK);
	 }
	 
	 @GetMapping("/employeedetails/{id}")
	 public ResponseEntity<?> getEmployeeDetails(@PathVariable int id)
	 {
		 StaffActualDTO staff = managerService.getEmployeeDetails(id);
		 return ResponseEntity.ok(staff);
	 }
	 
	 @GetMapping("/assignshift/{id}")
	 public ResponseEntity<?> assignShift(@PathVariable int id)
	 {
		 StaffActualDTO staff = managerService.getEmployeeDetails(id);
		 
		 return ResponseEntity.ok(staff);
	 }
	 
	 @PostMapping("/assignshift/{id}")
	 public ResponseEntity<?> assignPostMethod(@RequestBody StaffDTO staffDTO)
	 {
		 StaffActualDTO staff = (StaffActualDTO) managerService.assignShift(staffDTO);
		 return new ResponseEntity<>(staff,HttpStatus.OK);
//		 if(staff!=null)
//		 {
//			 HttpHeaders headers = new HttpHeaders();
//		     headers.add("Location", "/manager/stafflist");
//		     return new ResponseEntity<>(headers, HttpStatus. OK);
//		 }
//		 else
//		 {
//			 HttpHeaders headers = new HttpHeaders();
//		     headers.add("Location", "/manager/stafflist");
//		     return new ResponseEntity<>(headers, HttpStatus.NOT_MODIFIED);
//		 }
	 }
}
