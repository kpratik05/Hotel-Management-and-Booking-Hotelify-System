package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="salary_table")
@Getter
@Setter
@ToString
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salary_id")
	private int salaryId;
	
	private double amount;
	@Column(name="assigned_date")
	private LocalDate assignedDate;
	@OneToMany
	@JoinColumn(name="employee_id")
	private Employee employee;
}
