package com.app.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.BookingMap;

@Repository
public interface IBookingMapRepo extends JpaRepository<BookingMap, Integer> {
	@Query("select b from BookingMap b where b.mapId = ?1")
	public BookingMap findByMapId(int mapId);
	
	@Query("select b from BookingMap b where b.booking.bookingId = ?1")
	public Set<BookingMap> findByBookingId(int bookingId);
}
