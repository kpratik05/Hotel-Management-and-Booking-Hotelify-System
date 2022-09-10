package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Booking;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer> {

}
