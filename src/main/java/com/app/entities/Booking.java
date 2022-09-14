package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="booking")
@Getter
@Setter
@ToString
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	@NotNull
	private LocalDate bookingDate;
	@NotNull
	private LocalDate checkInDate;
	@NotNull
	private LocalDate checkOutDate;
	@Embedded
	private BookingMode mode;
	@NotNull
	private double bookingAmount;
	@NotNull
	private int totalDays;
	@NotNull
	private double totalAmount;
	@Embedded
	private Status status;
	@ManyToOne
	@JoinColumn(name="customer_id")
	@NotNull
	private Customer customer;
}
