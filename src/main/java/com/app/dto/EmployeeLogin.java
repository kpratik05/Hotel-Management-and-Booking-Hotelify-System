package com.app.dto;
import java.sql.Time;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeLogin {
	@JsonProperty("id")
	private int loginId;
	@NotBlank(message="This should not be blank loginTime")
	private Time loginTime;
	@NotBlank(message="This should not be blank logoutTime")
	private Time logoutTime;
	@NotBlank(message="This should not be blank date")
	private LocalDate date;
}
