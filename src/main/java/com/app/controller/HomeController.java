package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.app.dto.CheckInOutDTO;
import com.app.entities.Room;
import com.app.entities.Services;
import com.app.services.ICustomerService;
import com.app.services.IReservationStatusService;
import com.app.services.IRoomService;
import com.app.services.IServicesService;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	public IRoomService roomService;
	
	@Autowired 
	public IServicesService servicesService;
	@Autowired
	public IReservationStatusService reservationSerice;
	@Autowired
	public ICustomerService customerService;
	
	@GetMapping("/")
	public ResponseEntity<?> getHomePage()
	{
		return new ResponseEntity<>("Hello 007",HttpStatus.OK);
	}
	
	@GetMapping("/rooms")
	public ResponseEntity<?> getAllRooms()
	{
		System.out.println("Getting the list of rooms from repo "+getClass());
		List<Room> list = roomService.getAllRooms(); 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> getHotelDetails()
	{
		return ResponseEntity.ok("Hotel Details");
	}
	
	@GetMapping("/contactus")
	public ResponseEntity<?> getContacDetails()
	{
		return ResponseEntity.ok("Conatact Details");
	}
	
	@GetMapping("/services")
	public ResponseEntity<?> getHotelServices()
	{
		List<Services> services = servicesService.getServices();
		return new ResponseEntity<>(services,HttpStatus.OK);
	}
	
	@GetMapping("/services/{servicename}")
	public ResponseEntity<?> getHotelServiceDetails(@PathVariable String servicename)
	{
		System.out.println("break "+servicename);
		Services service = servicesService.getServiceDetails(servicename);
		System.out.println(service);
		return new ResponseEntity<>(service,HttpStatus.OK);
	}
	
	@GetMapping("/checkroom")
	public ResponseEntity<?> getAvailableRooms()
	{
		
		return ResponseEntity.ok("Book rooms from available list");
	} 
	
	@PostMapping("/checkroom")
	public ResponseEntity<?> getAvailableRooms(@RequestBody CheckInOutDTO dates)
	{
		System.out.println("checkInDate "+dates.getCheckInDate()+" checkOutdate "+dates.getCheckOutDate());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate checkIn = LocalDate.parse(dates.getCheckInDate(),df);
		LocalDate checkOut = LocalDate.parse(dates.getCheckOutDate(),df);
		reservationSerice.getRoomReservations(checkIn,checkOut);
		List<Room> availableRooms = reservationSerice.getAvailableRooms();
		return new ResponseEntity<>(availableRooms,HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> getLogInPage()
	{
		return ResponseEntity.ok("Fill Log in Info");
	}
	
	
}
