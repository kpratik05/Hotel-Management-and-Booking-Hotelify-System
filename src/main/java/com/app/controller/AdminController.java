package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.EmployeeLoginInfoDTO;
import com.app.entities.Admin;
import com.app.services.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	 @GetMapping("/login")
	 public ResponseEntity<?> getAdminLogin()
	 {
		 return ResponseEntity.ok("Enter admin ID and password");
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<?> getAdminDetails(@RequestBody EmployeeLoginInfoDTO loginInfo)
	 {
		 Admin admin = adminService.adminVerification(loginInfo.getId(), loginInfo.getPassword());
		 return new  ResponseEntity<>(admin,HttpStatus.OK);
	 }
}
