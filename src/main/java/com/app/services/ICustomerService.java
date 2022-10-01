package com.app.services;

import java.util.List;

import com.app.dto.CustomerDTO;
import com.app.entities.Booking;
import com.app.entities.Customer;
import com.app.entities.Payment;

public interface ICustomerService {
	public Customer getCustomerDetails(String email,String Password);
	
	//public Customer registerCustomer(CustomerDTO customerDTO);

	public Customer updateCustomerDetails(CustomerDTO customer);

	public List<Booking> getBookingHistory(int id);

	Customer registerCustomer(Customer c);

	CustomerDTO findUsingId(int id);
	
	Booking roomBooking();
	
	public List<Payment> getPaymentList(int id);
}
