package com.app.entities;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Time startTime;
	@Column(name="end_time")
	private Time endTime;
	private LocalDate date;
	@Column(length=100)
	private String instructions;
	@OneToOne
	@JoinColumn(name="dept_id")
	private Department department;
}
