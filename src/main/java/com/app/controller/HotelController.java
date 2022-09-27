package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.CheckRoomDTO;
import com.app.entities.Booking;
import com.app.services.IBookingService;


@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private IBookingService bookingService;
	
	@GetMapping("/allbooking")
	public ResponseEntity<?> getBookingList()
	{
		List<Booking> bookings = bookingService.getBookings(); 
		System.out.println(bookings);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
}
