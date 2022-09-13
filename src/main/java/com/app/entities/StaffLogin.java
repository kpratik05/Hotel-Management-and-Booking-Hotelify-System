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
@Table(name="staff_login")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class StaffLogin extends EmployeeLogin {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="staff_id")
	@NotNull
	private Staff staff;
}
