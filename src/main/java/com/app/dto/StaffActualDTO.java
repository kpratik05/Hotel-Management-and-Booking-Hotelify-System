package com.app.dto;

import com.app.entities.Role;
import com.app.entities.ShiftTable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffActualDTO extends EmployeeActualDTO {
	private ShiftTable shift;
	private Role role;
}
