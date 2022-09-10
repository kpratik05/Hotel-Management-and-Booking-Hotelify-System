package com.app.entities;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@MappedSuperclass
@Setter
@Getter
public class Person {
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String email;
	@Column(length=20)
	private String address;
	private int mobile_no;
	@Column(length=20)
	private String password;
	private LocalDate birth_date;
}
