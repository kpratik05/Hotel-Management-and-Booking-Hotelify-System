package com.app.dto;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDTO {
	@JsonProperty("id")
	private int bookingId;
	
	private LocalDate bookingDate;
	@NotBlank(message="Check in date should be mentioned")
	@Future(message = "join date msut be in future")
	private LocalDate checkInDate;
	@NotBlank(message="Check out date should be mentioned")
	@Future(message = "join date msut be in future")
	private LocalDate checkOutDate;
	@NotBlank(message="mode should be mentioned")
	private String modeOfBooking;
	@NotBlank(message="booking amount should be mentioned")
	private double bookingAmount;
	@NotBlank(message="total days should be mentioned")
	private int totalDays;
	@NotBlank(message="Total Amount should be mentioned")
	private double totalAmount;
	@NotBlank(message="status should be mentioned")
	private Status status;
	
	private CustomerDTO customer;
}
