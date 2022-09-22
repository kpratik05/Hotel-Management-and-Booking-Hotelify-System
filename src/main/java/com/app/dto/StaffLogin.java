package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffLogin extends EmployeeLogin {
	
	private StaffDTO staff;
}
