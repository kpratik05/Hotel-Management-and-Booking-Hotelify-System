package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salary_id")
	private int salaryId;
	@NotNull
	private double amount;
	@Column(name="assigned_date")
	@NotNull
	private LocalDate assignedDate;

	
}
