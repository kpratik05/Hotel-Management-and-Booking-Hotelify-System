package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Booking;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer> {
	@Query("select b from Booking b left join fetch b.customerInfo left join fetch b.bookingMode")
	public List<Booking> getAllBookings();
}
