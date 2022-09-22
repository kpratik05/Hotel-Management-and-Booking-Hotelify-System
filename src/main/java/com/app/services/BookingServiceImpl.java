package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingRepo;
import com.app.entities.Booking;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {
	@Autowired
	private IBookingRepo bookingRepo;
	
	@Override
	public List<Booking> getBookings() {
		
		return bookingRepo.getAllBookings();
	}

}
