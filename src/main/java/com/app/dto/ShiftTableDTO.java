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
public class ShiftTableDTO {
	@JsonProperty("id")
	private int shiftId;
	@NotBlank
	private Time startTime;
	@NotBlank
	private Time endTime;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private String instructions;
	@NotBlank
	private int department;
}
