package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.BookingDTO;
import com.app.dto.EmployeeLoginInfoDTO;
import com.app.dto.ManagerActualDTO;
import com.app.dto.StaffActualDTO;
import com.app.dto.StaffDTO;
import com.app.dto.StaffFeedbackDTO;
import com.app.entities.Manager;
import com.app.entities.ManagerLogin;
import com.app.entities.Staff;
import com.app.entities.StaffFeedback;
import com.app.services.IBookingService;
import com.app.services.IManagerService;
@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private IManagerService managerService;
	
	@Autowired
	private IBookingService bookingService;
	
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
		 Manager m = (Manager) session.getAttribute("user");
		 System.out.println("login "+m.getName());
		 return new  ResponseEntity<>(manager,HttpStatus.OK);
	 }
	 
	 @GetMapping("/logout")
	 public ResponseEntity<?> logoutManager(HttpSession session)
	 {
		 session.removeAttribute("user");
		 return new ResponseEntity<>("logged out seuccessfully",HttpStatus.OK);
	 }
	 
	 @GetMapping("/profile/{id}")
	 public ResponseEntity<?> getProfile(@PathVariable int id,HttpSession session)
	 {
		 System.out.println("manager profile "+session.getAttribute("user"));
		 ManagerActualDTO m = managerService.findUsingId(id);
		 return new ResponseEntity<>(m,HttpStatus.OK);
	 }
	 
	 @GetMapping("/update")
	 public ResponseEntity<?> updateManagerInfo(HttpSession session)
	 {
		 Manager manager = (Manager) session.getAttribute("user");
		 System.out.println("Manager = "+manager.getEmail());
		 return ResponseEntity.ok(session.getAttribute("user"));
	 }
	 
	 @PostMapping("/update")
	 public ResponseEntity<?> updateManager(@RequestBody ManagerActualDTO manager,HttpSession session)
	 {
		 Manager managerEnt = managerService.updateManagerDetails(manager);
		 session.setAttribute("user", managerEnt);
	     return new ResponseEntity<>(managerEnt, HttpStatus. OK);
	 }
	 
	 @GetMapping("/stafflist/{deptId}")
	 public ResponseEntity<?> getEmployeesFromDepartment(@PathVariable int deptId)
	 {
		 System.out.println("Staff list "+deptId);
		 List<Staff> staffList =managerService.getEmployeesInDepartment(deptId);
		 return new ResponseEntity<>(staffList,HttpStatus.OK);
	 }
	 
	 @GetMapping("/employeedetails/{id}")
	 public ResponseEntity<?> getEmployeeDetails(@PathVariable int id)
	 {
		 System.out.println("details employe "+id);
		 StaffActualDTO staff = managerService.getEmployeeDetails(id);
		 return new ResponseEntity<>(staff,HttpStatus.OK);
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
		 System.out.println("change shift : "+staffDTO.getShift());
		 Staff staff =  managerService.assignShift(staffDTO);
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
	 
	 @GetMapping("/employeefeedbacklist/{id}")
	 public ResponseEntity<?> getEmployeeFeedbackOfDepartment(@PathVariable int id)
	 {
		 List<StaffFeedback> staffFeedback = managerService.getEmployeeFeedback(id);
		 return new ResponseEntity<>(staffFeedback,HttpStatus.OK);
	 }
	 
	 @GetMapping("/addfeedback/{id}")
	 public ResponseEntity<?> addFeedback()
	 {
		return ResponseEntity.ok("Add feedback"); 
	 }
	 
	 @PostMapping("/addfeedback/{id}")
	 public ResponseEntity<?> addTwoFeedback(@RequestBody StaffFeedbackDTO staffDTO)
	 {
		 System.out.println(("addfeedback "+staffDTO.getStaff()));
		 return new ResponseEntity<>(managerService.addFeedback(staffDTO),HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/employeefeedback/employee/{id}")
	 public ResponseEntity<?> getEmployeeFeedback(@PathVariable int id)
	 {
		 System.out.println("fire "+id);
		 return new ResponseEntity<>(managerService.getFeedbackFromEmployeeId(id),HttpStatus.OK);
	 }
	 
	 @GetMapping("/employeefeedback/{id}")
	 public ResponseEntity<?> getSpecificFeedback(@PathVariable int id)
	 {
		 
		 return new ResponseEntity<>(managerService.getEmployeeFeedbackFromId(id),HttpStatus.OK);
	 }
	 
	 @GetMapping("/customerpayment")
	 public ResponseEntity<?> getPaymentList()
	 {
		 return new ResponseEntity<>(managerService.getPaymentList(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/stafflogin/{dept}")
	 public ResponseEntity<?> getStaffLogin(@PathVariable int dept)
	 {
		 return new ResponseEntity<>(managerService.getStaffLoginFromDept(dept),HttpStatus.OK);
	 }
	 
	 @GetMapping("/managerlogin/{id}")
	 public ResponseEntity<?> getManagerLogin(@PathVariable int id,HttpSession session)
	 {
		 List<ManagerLogin> manLoginList = managerService.getManagerLogin(id);
		 return new ResponseEntity<>(manLoginList,HttpStatus.OK);
	 }
	 
	 @PostMapping("/bookroom/{id}")
	 public ResponseEntity<?> bookRoom(@RequestBody BookingDTO booking,@PathVariable int id )
	 {
		 return new ResponseEntity<>(bookingService.bookRoom(id, booking),HttpStatus.OK);
	 }
}
