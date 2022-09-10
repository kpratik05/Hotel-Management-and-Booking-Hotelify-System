package com.app.services;

import com.app.entities.Customer;

public interface ICustomerService {
	public Customer getCustomerDetails(String email,String Password);
	
	public void registerCustomer(Customer c);
}
