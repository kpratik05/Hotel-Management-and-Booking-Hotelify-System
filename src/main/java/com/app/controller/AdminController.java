package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.app.dto.RoomDTO;
import com.app.dto.ShiftTableDTO;
import com.app.dto.StaffDTO;
import com.app.entities.Admin;
import com.app.services.IAdminService;
import com.app.services.IStaffService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IStaffService staffService;
	
	
	 @GetMapping("/login")
	 public ResponseEntity<?> getAdminLogin()
	 {
		 return ResponseEntity.ok("Enter admin ID and password");
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<?> getAdminDetails(@RequestBody EmployeeLoginInfoDTO loginInfo,HttpSession session)
	 {
		 Admin admin = adminService.adminVerification(loginInfo.getId(), loginInfo.getPassword());
		 session.setAttribute("user", admin);
		 return new  ResponseEntity<>(admin,HttpStatus.OK);
	 }
	 
	 @GetMapping("/register/staff")
	 public ResponseEntity<?> getRegisterForm()
	 {
		 return ResponseEntity.ok("Enter staff details");
	 }
	 
	 @PostMapping("/register/staff")
	 public ResponseEntity<?> registerStaff(@RequestBody StaffDTO staffDTO)
	 {
		return new ResponseEntity<>(adminService.registerStaff(staffDTO),HttpStatus.OK); 
	 }
	 
	 @GetMapping("/register/manager")
	 public ResponseEntity<?> getManagerRegister()
	 {
		 return ResponseEntity.ok("Enter Manager details");
	 }
	 
	 @PostMapping("/register/manager")
	 public ResponseEntity<?> registerManager(@RequestBody ManagerDTO mDTO)
	 {
		return new ResponseEntity<>(adminService.registerManager(mDTO),HttpStatus.OK); 
	 }
	 
	 @GetMapping("/addroom")
	 public ResponseEntity<?> addRooom()
	 {
		 return ResponseEntity.ok("Enter Room details");
	 }
	 
	 @PostMapping("/addroom")
	 public ResponseEntity<?> addPostRooom(@RequestBody RoomDTO roomDTO)
	 {
		 return new ResponseEntity<>(adminService.addRoom(roomDTO),HttpStatus.OK);
	 }
	 
	 @GetMapping("/updateroom/{id}")
	 public ResponseEntity<?> getUpdateRoomInfo(@PathVariable int id)
	 {
		 return new ResponseEntity<>(adminService.getRoomInfo(id),HttpStatus.OK);
	 }
	 
	 @PostMapping("/updateroom/{id}")
	 public ResponseEntity<?> updatedRoomInfo(@RequestBody RoomDTO roomDTO,@PathVariable int id)
	 {
		 roomDTO.setRoomId(id);
		 return new ResponseEntity<>(adminService.updateRoom(roomDTO),HttpStatus.OK);
	 }
	 
	 @GetMapping("/addshift")
	 public ResponseEntity<?> getShiftInfo()
	 {
		 return ResponseEntity.ok("Add shift info");
	 }
	 
	 @PostMapping("/addshift")
	 public ResponseEntity<?> addNewShift(@RequestBody ShiftTableDTO shiftDTO)
	 {
		 return new ResponseEntity<>(adminService.addShift(shiftDTO),HttpStatus.OK);
	 }
	 
	 @GetMapping("/updateshift/{id}")
	 public ResponseEntity<?> updateGetShift(@PathVariable int id)
	 {
		 return ResponseEntity.ok(adminService.getShiftInfo(id));
	 }
	 
	 @PostMapping("/updateshift/{id}")
	 public ResponseEntity<?> updateShift(@RequestBody ShiftTableDTO shiftDTO,@PathVariable int id)
	 {
		 shiftDTO.setShiftId(id);
		 System.out.println(shiftDTO);
		 return new ResponseEntity<>(adminService.updateShift(shiftDTO),HttpStatus.OK);
	 }
	 
	 @GetMapping("/shiftlist/{id}")
	 public ResponseEntity<?> getShiftInfo(@PathVariable int id)
	 {
		 return new ResponseEntity<>(adminService.getShiftInfo(id),HttpStatus.OK);
	 }

	 @GetMapping("/roomlist/{id}")
	 public ResponseEntity<?> getRoomInfo(@PathVariable int id)
	 {
		 return new ResponseEntity<>(adminService.getRoomInfo(id),HttpStatus.OK);
	 }
	 
	 @GetMapping("/roomlist")
	 public ResponseEntity<?> getRoomList()
	 {
		 return new ResponseEntity<>(adminService.getRoomList(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/shiftlist")
	 public ResponseEntity<?> getShiftList()
	 {
		 return new ResponseEntity<>(adminService.getShiftList(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/removeemployee/{id}")
	 public ResponseEntity<?> removeGetEmployee(@PathVariable int id)
	 {
		 boolean b =  adminService.removeEmployee(id);
		 if(b==true)
		 {
			 return ResponseEntity.ok("Successfully removed employee with id "+id);
		 }
		 return ResponseEntity.ok("Unsuccessfull in removing employee with id "+id);
	 }
}
