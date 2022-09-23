package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPaymentRepo;
import com.app.entities.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepo paymentRepo;
	
	@Override
	public List<Payment> getPaymentList() {
		
		return paymentRepo.getPaymentList();
	}

}
