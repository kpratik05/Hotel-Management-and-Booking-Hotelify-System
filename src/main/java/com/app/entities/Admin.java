package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="admin")
@Getter
@Setter
@ToString
public class Admin extends Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
}
