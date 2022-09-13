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
@Table(name="department")
@Setter
@Getter
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	private int deptId;
	@Column(length=20,name="dept_name")
	@NotNull
	private String deptName;
	@Column(length=50,name="dept_desc")
	@NotNull
	private String deptDesc;
	//the assigned manager's id should be displayed here 
	@Column(name="manager_id")
	@NotNull
	private int managerId;
}
