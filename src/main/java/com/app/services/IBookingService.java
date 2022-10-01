package com.app.services;

import java.util.List;

import com.app.dto.BookingDTO;
import com.app.dto.PaymentDTO;
import com.app.entities.Booking;
import com.app.entities.Payment;

public interface IBookingService {
	public List<Booking> getBookings();
	
	public Booking bookRoom(int id,BookingDTO bookingDTO);
	
	public Payment addPayment(PaymentDTO paymentDTO);
	
	public Booking getBookingDetails(int id);
}
