package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingRepo;
import com.app.dto.BookingActualDTO;
import com.app.dto.BookingDTO;
import com.app.dto.CustomerDTO;
import com.app.dto.PaymentDTO;
import com.app.entities.Booking;
import com.app.entities.BookingMode;
import com.app.entities.Customer;
import com.app.entities.Payment;
import com.app.entities.ReservationStatus;
import com.app.entities.Status;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService {
	@Autowired
	private IBookingRepo bookingRepo;
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IRoomService roomService;
	@Autowired
	private IRoomCategoryService roomCatService;
	@Autowired
	private IReservationStatusService resService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IPaymenModeService paymentModeService;
	@Override
	public List<Booking> getBookings() {
		
		return bookingRepo.getAllBookings();
	}

	@Override
	public Booking bookRoom(int id,BookingDTO bookingDTO) {
		BookingActualDTO bookingActual = new BookingActualDTO();
		bookingActual.setBookingAmount(bookingDTO.getBookingAmount());
		bookingActual.setBookingDate(bookingDTO.getBookingDate());
		bookingActual.setCheckInDate(bookingDTO.getCheckInDate());
		bookingActual.setCheckOutDate(bookingDTO.getCheckOutDate());
		CustomerDTO cdto = custService.findUsingId(bookingDTO.getCustomer());
		Customer c = mapper.map(cdto, Customer.class);
		bookingActual.setCustomer(c);
		BookingMode b = bookingRepo.getBookingModeFromId(bookingDTO.getModeOfBooking());
		bookingActual.setModeOfBooking(b);
		Status s = bookingRepo.getStatusFromId(bookingDTO.getStatus());
		bookingActual.setStatus(s);
		bookingActual.setTotalAmount(bookingDTO.getTotalAmount());
		bookingActual.setTotalDays(bookingDTO.getTotalDays());
		Booking bking = mapper.map(bookingActual, Booking.class);
		ReservationStatus res = new ReservationStatus();
		res.setCheckInDate(bking.getCheckInDate());
		res.setCheckOutDate(bking.getCheckOutDate());
		res.setRoom(roomService.getRoomDetails(id));
		res.setRoomCategory(roomCatService.getRoomCategory(res.getRoom().getRoomCategory().getCatId()));
		res.setStatus(bking.getStatus());
		resService.saveReservation(res);
		return bookingRepo.save(bking);
	}

	@Override
	public Payment addPayment(PaymentDTO paymentDTO) {	
		Payment p = new Payment();
		
		p.setBooking(getBookingDetails(paymentDTO.getBooking()));
		p.setEmployeeId(paymentDTO.getEmployeeId());
		p.setPaymentDate(paymentDTO.getPaymentDate());
		p.setPaymentMode(paymentModeService.getFromId(paymentDTO.getPaymentMode()));
		p.setTotalAmount(paymentDTO.getTotalAmount());	
		
		return paymentService.addPayment(p);
	}

	@Override
	public Booking getBookingDetails(int id) {
		// TODO Auto-generated method stub
		return bookingRepo.getBookingDetails(id);
	}
	
	

}
