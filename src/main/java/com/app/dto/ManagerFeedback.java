package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ManagerFeedback extends EmployeeFeedback {
	
	private ManagerDTO manager;
}
