package com.app.entities;
import java.sql.Time;
import java.time.LocalDate;

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
@Table(name="login_table")
@Setter
@Getter
@ToString
public class EmployeeLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int login_id;
	
	private Time login_time;
	private Time logout_time;
	private LocalDate date;
	@OneToMany
	@JoinColumn(name="employee_id")
	private Employee employee;
	@OneToMany
	@JoinColumn(name="dept_id")
	private Department department;
}
