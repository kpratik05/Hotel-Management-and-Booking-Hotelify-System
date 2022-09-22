package com.app.dto;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;
	@Column(name="payment_date")
	@NotNull
	private LocalDate paymentDate;
	@Column(name="payment_mode")
	@NotNull
	private PaymentMode paymentMode;
	@Column(name="total_amount")
	@NotNull
	private double totalAmount;
	@Column(name="employee_id")
	@NotNull
	private int employeeId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id")
	@NotNull
	private BookingDTO booking;
}
