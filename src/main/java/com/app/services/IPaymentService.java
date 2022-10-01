package com.app.services;

import java.util.List;

import com.app.dto.PaymentDTO;
import com.app.entities.Payment;

public interface IPaymentService {
	public List<Payment> getPaymentList();
	
	public Payment addPayment(Payment pDTO);
	
	public List<Payment> getCustomerPayment(int id);
}
