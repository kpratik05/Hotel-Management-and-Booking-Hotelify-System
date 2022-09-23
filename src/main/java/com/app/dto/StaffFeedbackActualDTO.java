package com.app.dto;

import com.app.entities.Staff;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StaffFeedbackActualDTO extends EmployeeFeedbackDTO {
	
	private Staff staff;
}
