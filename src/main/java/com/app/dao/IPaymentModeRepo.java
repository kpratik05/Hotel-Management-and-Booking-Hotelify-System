package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.PaymentMode;

@Repository
public interface IPaymentModeRepo extends JpaRepository<PaymentMode, Integer> {
	@Query("select p from PaymentMode p where p.id=id")
	public PaymentMode getFromId(int id);
}
