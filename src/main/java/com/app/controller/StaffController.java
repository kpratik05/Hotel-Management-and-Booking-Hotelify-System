package com.app.controller;

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
import com.app.dto.CustomerDTO;
import com.app.dto.EmployeeLoginInfoDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Staff;
import com.app.services.IAdminService;
import com.app.services.ICustomerService;
import com.app.services.IStaffLoginService;
import com.app.services.IStaffService;

@CrossOrigin(origins = { "http://localhost:3000" })
@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private IStaffService staffService;

	 @Autowired IAdminService adminService;
	 
	 @Autowired
	 ICustomerService custService;

	@GetMapping("/login")
	public ResponseEntity<?> staffLogin() {
		return ResponseEntity.ok("Enter Employee ID and password");
	}

	@PostMapping("/login")
	public ResponseEntity<?> getstaffDetails(@RequestBody EmployeeLoginInfoDTO loginInfo, HttpSession session) {
		System.out.println(loginInfo.getId() + " " + loginInfo.getPassword());
		Staff staff = staffService.getStaffDetails(loginInfo.getId(), loginInfo.getPassword());
		session.setAttribute("user", staff);
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<?> getProfile(@PathVariable int id) {
		return new ResponseEntity<>(staffService.findUsingId(id), HttpStatus.OK);
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<?> updateEmployeeInfo(@PathVariable int id) {
		return ResponseEntity.ok(staffService.findUsingId(id));
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody StaffDTO staff, HttpSession session) {
		Staff staffEnt = staffService.updateStaffDetails(staff);
		return new ResponseEntity<>(staffEnt, HttpStatus.OK);
	}
	 
	@GetMapping("/shift/{id}")
	public ResponseEntity<?> checkShiftDetails(@PathVariable int id) {
		return new ResponseEntity<>(staffService.getShift(id), HttpStatus.OK);
	}
	
//	@PostMapping("/roomBooking")
//	public ResponseEntity<?> bookRoom(@RequestBody BookingDTO book)
//	{	
//		return new ResponseEntity<>(staffService.bookingRoom(book), HttpStatus.OK);
//	}

}
