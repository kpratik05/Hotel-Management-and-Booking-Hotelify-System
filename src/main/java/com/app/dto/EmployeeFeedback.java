package com.app.dto;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class EmployeeFeedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeefeedback_id")
	private int employeeFeedbackId;
	@Column(length=50)
	@NotNull
	private String feedback;
	@NotNull
	private LocalDate date;
	
}
