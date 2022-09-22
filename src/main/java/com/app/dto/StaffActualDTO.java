package com.app.dto;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffActualDTO extends EmployeeActualDTO {
	private ShiftTableDTO shift;
	private Role role;
}
