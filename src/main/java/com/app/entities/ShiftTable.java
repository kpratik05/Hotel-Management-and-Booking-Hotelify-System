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
	private int shift_id;
	
	private Time start_time;
	private Time end_time;
	private LocalDate date;
	@Column(length=100)
	private String instructions;
	@OneToOne
	@JoinColumn(name="dept_id")
	private Department department;
}
