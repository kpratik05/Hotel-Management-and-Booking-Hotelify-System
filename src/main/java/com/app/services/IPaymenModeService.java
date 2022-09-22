package com.app.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.PaymentMode;

@Service
@Transactional
public interface IPaymenModeService {
	public PaymentMode getFromId(int id);
}
