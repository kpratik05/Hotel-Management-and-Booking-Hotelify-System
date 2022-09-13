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
@Table(name="staff_feedback")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class StaffFeedback extends EmployeeFeedback {
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="staff_id")
	@NotNull
	private Staff staff;
}
