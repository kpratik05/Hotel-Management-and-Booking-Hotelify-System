package com.app.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingRepo;
import com.app.dao.ICustomerRepo;
import com.app.dto.CustomerDTO;
import com.app.entities.Booking;
import com.app.entities.Customer;
import com.app.entities.Payment;



@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepo custRepo;
	
	@Autowired
	private IBookingRepo bookRepo;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Customer getCustomerDetails(String email, String Password) {
		Customer c = custRepo.findByEmailAndPassword(email, Password);
		if(c!=null)
		{
			return c;
		}
		else {
			System.out.println("Customer could not be found with this email and password");
			return null;
		}
	}

	@Override
	public Customer registerCustomer(Customer c) {
		CustomerDTO customer = new CustomerDTO();
		customer.setAddress(c.getAddress());
		customer.setBirthDate(c.getBirthDate());
		customer.setEmail(c.getEmail());
		customer.setMobileNo(c.getMobileNo());
		customer.setName(c.getName());
		customer.setPassword(c.getPassword());
		Customer cust = mapper.map(c, Customer.class);
		custRepo.save(c);
		return c;

	}
	
	@Override
	public CustomerDTO findUsingId(int id) {
		// TODO Auto-generated method stub
		Customer cust = custRepo.findById(id);
		CustomerDTO custDTO = mapper.map(cust, CustomerDTO.class);
		return custDTO;
	}


	@Override
	public Customer updateCustomerDetails(CustomerDTO customer) {
		CustomerDTO updateCustomer = findUsingId(customer.getCustomerId());
		updateCustomer.setAddress(customer.getAddress());
		updateCustomer.setBirthDate(customer.getBirthDate());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setMobileNo(customer.getMobileNo());
		updateCustomer.setName(customer.getName());
		updateCustomer.setPassword(customer.getPassword());
		Customer newCustomer = mapper.map(updateCustomer, Customer.class);
		Customer customerAfter = custRepo.save(newCustomer);
		return customerAfter;
	}

	@Override
	public List<Booking> getBookingHistory(int id) {
		return bookRepo.getCustomerBooking(id); 
	}

	@Override
	public Booking roomBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getPaymentList(int id) {
		// TODO Auto-generated method stub
		return paymentService.getCustomerPayment(id);
	}
	


}
