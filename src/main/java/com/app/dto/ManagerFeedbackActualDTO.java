package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ManagerFeedbackActualDTO extends EmployeeFeedbackDTO {
	
	private ManagerDTO manager;
}
