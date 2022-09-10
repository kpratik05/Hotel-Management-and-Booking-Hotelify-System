package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="department")
@Setter
@Getter
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dept_id;
	@Column(length=20)
	private String dept_name;
	@Column(length=50)
	private String dept_desc;
	//the assigned manager's id should be displayed here 
	private String manager_id;
}
