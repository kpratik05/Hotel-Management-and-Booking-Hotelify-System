package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Person {
	@Column(length=20)
	@NotNull
	private String name;
	@Column(length=20)
	@NotNull
	private String email;
	@Column(length=20)
	@NotNull
	private String address;
	@NotNull
	private int mobileNo;
	@Column(length=20)
	@NotNull
	private String password;
	@NotNull
	private LocalDate birthDate;
}
