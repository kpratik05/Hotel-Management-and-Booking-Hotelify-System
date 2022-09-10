package com.app.entities;
import java.time.LocalDate;

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
@Table(name="customer_feedback")
@Getter
@Setter
@ToString
public class CustomerFeedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cfeedback_id;
	@Column(length=50)
	private String feedback;
	private LocalDate date;
	private String booking_id;
}
