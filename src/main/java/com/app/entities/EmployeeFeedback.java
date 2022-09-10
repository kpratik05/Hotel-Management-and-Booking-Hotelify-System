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
@Table(name="Employee_feedback")
@Setter
@Getter
@ToString
public class EmployeeFeedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeefeedback_id;
	@Column(length=50)
	private String feedback;
	private LocalDate date;
	@OneToMany
	@JoinColumn(name="employee_id")
	private Employee employee;
}
