package com.app.dto;

import javax.validation.constraints.NotBlank;

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
	@NotBlank(message="Dparrtment can not be blank")
	private Department department;
}
