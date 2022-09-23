package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private int cfeedbackId;
	
	@NotNull
	private String feedback;
	@NotNull
	private LocalDate date;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id")
	@NotNull
	private Booking booking;
}
