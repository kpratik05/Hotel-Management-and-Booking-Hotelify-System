package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="roles")
@Getter
@Setter
@ToString
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	@Column(length=30)
	@NotNull
	private String role;
	
}
