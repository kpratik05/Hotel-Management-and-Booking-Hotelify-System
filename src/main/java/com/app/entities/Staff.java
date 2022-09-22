package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Staff")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Staff extends Employee {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="shift_id")
	@NotNull
	private ShiftTable shift;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	@NotNull
	private Role role;
	
}
