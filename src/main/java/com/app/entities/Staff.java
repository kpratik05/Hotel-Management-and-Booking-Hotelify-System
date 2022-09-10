package com.app.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="Staff")
@Getter
@Setter
@ToString
public class Staff extends Employee {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="shift_id")
	private ShiftTable shift;
	@Embedded
	private Role role;
}
