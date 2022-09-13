package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="staff_salary")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class StaffSalary extends EmployeeSalary {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="staff_id")
	private Staff staff;
}
