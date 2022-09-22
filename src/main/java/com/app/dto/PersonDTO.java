package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonDTO {
	@NotBlank(message="name should not be blank")
	private String name;
	@NotBlank(message="email should not be blank")
	private String email;
	@NotBlank(message="address should not be blank")
	private String address;
	@NotBlank(message="mobileNo should not be blank")
	private int mobileNo;
	@NotBlank(message="password should not be blank")
	private String password;
	@NotBlank(message="birthDate should not be blank")
	private LocalDate birthDate;
}
