package com.app.dto;

import com.app.entities.Staff;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffLogin extends EmployeeLogin {
	
	private Staff staff;
}
