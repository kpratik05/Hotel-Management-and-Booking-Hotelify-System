package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagerLoginDTO extends EmployeeLoginInfoDTO {
	
	private ManagerDTO manager;
}
