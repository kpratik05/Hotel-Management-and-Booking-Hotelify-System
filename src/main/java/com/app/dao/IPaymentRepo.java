package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Payment;

@Repository
public interface IPaymentRepo extends JpaRepository<Payment, Integer> {
	@Query("select p from Payment p left join fetch p.booking left join fetch p.paymentMode")
	public List<Payment> getPaymentList();
	
	@Query("select p from Payment p left join fetch p.booking left join fetch p.paymentMode where p.booking.customer.customerId = ?1")
	public List<Payment> getCustomerPayment(int id);
}
