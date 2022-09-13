package com.app.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="staff_feedback")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class StaffFeedback extends EmployeeFeedback {
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="staff_id")
	private Staff staff;
}
