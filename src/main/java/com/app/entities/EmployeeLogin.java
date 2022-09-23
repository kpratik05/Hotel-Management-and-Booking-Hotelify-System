package com.app.entities;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class EmployeeLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login_id")
	private int loginId;
	@Column(name="login_time")
	@NotNull
	private Time loginTime;
	@Column(name="logout_time")
	@NotNull
	private Time logoutTime;
	@NotNull
	private LocalDate date;
}
