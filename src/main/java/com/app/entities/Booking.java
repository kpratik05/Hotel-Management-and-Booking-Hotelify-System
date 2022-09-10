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
	private int booking_id;
	private LocalDate booking_date;
	private LocalDate check_in_date;
	private LocalDate check_out_date;
	@Embedded
	private BookingMode mode;
	private double booking_amount;
	private int total_days;
	private double total_amount;
	@Embedded
	private Status status;
	@OneToMany
	@JoinColumn(name="customer_id")
	private Customer customer;
}
