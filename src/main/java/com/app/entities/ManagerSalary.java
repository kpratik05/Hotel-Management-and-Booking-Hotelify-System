package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="manager_salary")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ManagerSalary extends EmployeeSalary {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	@NotNull
	private Manager manager;
}
