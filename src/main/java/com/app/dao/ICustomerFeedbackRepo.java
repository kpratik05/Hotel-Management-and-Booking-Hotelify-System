package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CustomerFeedback;

@Repository
public interface ICustomerFeedbackRepo extends JpaRepository<CustomerFeedback, Integer> {

}
