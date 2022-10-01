package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.BookingDTO;
import com.app.dto.PaymentDTO;
import com.app.entities.Booking;
import com.app.services.IBookingService;
import com.app.services.IRoomService;


@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private IBookingService bookingService;
	@Autowired
	private IRoomService roomService;

	@GetMapping("/allbooking")
	public ResponseEntity<?> getBookingList()
	{
		List<Booking> bookings = bookingService.getBookings(); 
		System.out.println(bookings);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	
	@GetMapping("/roomdetails/{id}")
	public ResponseEntity<?> getRoomDetails(@PathVariable int id)
	{
		return new ResponseEntity<>(roomService.getRoomInfo(id),HttpStatus.OK);
	}
	
	@PostMapping("/bookroom/{id}")
	public ResponseEntity<?> bookRoom(@RequestBody BookingDTO booking,@PathVariable int id)
	{
		System.out.println("booking");
		return new ResponseEntity<>(bookingService.bookRoom(id,booking),HttpStatus.OK);	
	}
	
	@GetMapping("/bookingdetails/{id}")
	public ResponseEntity<?> getBookingInfo(@PathVariable int id)
	{
		return new ResponseEntity<>(bookingService.getBookingDetails(id),HttpStatus.OK);
	}
	
	@PostMapping("/payment")
	public ResponseEntity<?> addPayment(@RequestBody PaymentDTO pDTO)
	{
		return new ResponseEntity<>(bookingService.addPayment(pDTO),HttpStatus.OK);
	}
}
