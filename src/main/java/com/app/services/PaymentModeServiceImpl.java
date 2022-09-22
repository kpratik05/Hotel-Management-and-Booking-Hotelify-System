package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPaymentModeRepo;
import com.app.entities.PaymentMode;

@Service
@Transactional
public class PaymentModeServiceImpl implements IPaymenModeService {

	@Autowired
	private IPaymentModeRepo paymentModeRepo;
	
	@Override
	public PaymentMode getFromId(int id) {
		
		return paymentModeRepo.getFromId(id);
	}

}
