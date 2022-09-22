package com.app.dto;
import java.time.LocalDate;

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

@Getter
@Setter
@ToString
public class CustomerFeedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cfeedback_id")
	private int cfeedbackId;
	@Column(length=50)
	@NotNull
	private String feedback;
	@NotNull
	private LocalDate date;
	@Column(name="booking_id")
	@NotNull
	private int bookingId;
}
