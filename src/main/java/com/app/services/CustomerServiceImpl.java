package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerRepo;
import com.app.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerRepo custRepo;
	
	@Override
	public Customer getCustomerDetails(String email, String Password) {
		Customer c = custRepo.findByEmailAndPassword(email, Password);
		if(c!=null)
		{
			return c;
		}
		else {
			System.out.println("Cusotmer could not be found with this email and password");
			return null;
		}
	}

	@Override
	public void registerCustomer(Customer c) {
		custRepo.save(c);

	}

}
