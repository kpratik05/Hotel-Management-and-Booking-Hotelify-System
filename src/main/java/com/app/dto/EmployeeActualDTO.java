package com.app.dto;

import com.app.entities.Department;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeActualDTO extends PersonDTO {
	@JsonProperty("employeeId")
	private int employeeId;
	private Department department;
}
