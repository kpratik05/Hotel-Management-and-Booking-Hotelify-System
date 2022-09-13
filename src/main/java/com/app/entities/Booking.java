package com.app.entities;
import javax.persistence.*;


import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="booking")
@Getter
@Setter
@ToString
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private LocalDate bookingDate;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	@Embedded
	private BookingMode mode;
	private double bookingAmount;
	private int totalDays;
	private double totalAmount;
	@Embedded
	private Status status;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
}
