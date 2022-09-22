package com.app.dto;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffDTO extends EmployeeDTO {
	
	
	private int shift;
	private Role role;
}
