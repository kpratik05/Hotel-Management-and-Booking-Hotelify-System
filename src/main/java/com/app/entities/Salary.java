package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="salary")
@Getter
@Setter
@ToString
public class Salary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salary_id")
	private int salaryId;
	private double amount;
	@Column(name="assigned_date")
	private LocalDate assignedDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
}
