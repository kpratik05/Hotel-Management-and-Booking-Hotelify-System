package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagerSalary extends EmployeeSalary {
	
	private ManagerDTO manager;
}
