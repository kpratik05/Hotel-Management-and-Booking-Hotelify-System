package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.email=?1 and c.password=?2") 
	public Customer findByEmailAndPassword(String email,String password);
	
	@Query("select c from Customer c where c.customerId=?1")
	public Customer findById(int id);
	
	
}
