package com.app.entities;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="shift_table")
@Getter
@Setter
@ToString
public class ShiftTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shift_id")
	private int shiftId;
	@Column(name="start_time")
	@NotNull
	private Time startTime;
	@Column(name="end_time")
	@NotNull
	private Time endTime;
	@NotNull
	private LocalDate date;
	@Column(length=100)
	private String instructions;
}
