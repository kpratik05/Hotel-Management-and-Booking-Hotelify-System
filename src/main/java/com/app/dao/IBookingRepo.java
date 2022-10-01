package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Booking;
import com.app.entities.BookingMode;
import com.app.entities.Status;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer> {
	@Query("select b from Booking b left join fetch b.customer left join fetch b.bookingMode left join fetch b.status")
	public List<Booking> getAllBookings();
	
	@Query("select b from Booking b left join fetch b.customer left join fetch b.bookingMode left join fetch b.status where b.customer.customerId=?1")
	public List<Booking> getCustomerBooking(int id);
	
	@Query("select b from BookingMode b where b.id = ?1")
	public BookingMode getBookingModeFromId(int id);
	
	@Query("select s from Status s where s.id=?1")
	public Status getStatusFromId(int id);
	
	@Query("select b from Booking b left join fetch b.customer left join fetch b.bookingMode left join fetch b.status where b.bookingId=?1")
	public Booking getBookingDetails(int id);
}
