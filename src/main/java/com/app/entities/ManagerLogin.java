package com.app.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="manager_login")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ManagerLogin extends EmployeeLogin {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;
}
