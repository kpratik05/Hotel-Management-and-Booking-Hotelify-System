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
	@Column(name="cfeedback_id")
	private int cfeedbackId;
	@Column(length=50)
	private String feedback;
	private LocalDate date;
	@Column(name="booking_id")
	private int bookingId;
}
