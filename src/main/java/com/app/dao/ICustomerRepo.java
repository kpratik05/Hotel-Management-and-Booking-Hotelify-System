package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer findByEmailAndPassword(String email,String password);
}
