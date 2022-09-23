package com.app.dto;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeFeedbackDTO {
	@NotBlank
	private String feedback;
	@NotBlank
	private LocalDate date;
	
}
