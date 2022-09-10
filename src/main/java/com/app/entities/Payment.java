package com.app.entities;
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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="payment")
@Getter
@Setter
@ToString
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;
	@Column(name="payment_date")
	private LocalDate paymentDate;
	@Column(name="payment_mode")
	private PaymentMode paymentMode;
	@Column(name="total_amount")
	private double totalAmount;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id")
	private Booking booking;
}
