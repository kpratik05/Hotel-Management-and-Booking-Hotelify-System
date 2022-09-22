package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.ReservationStatus;
import com.app.entities.Room;

@Repository
public interface IReservationStatusRepo extends JpaRepository<ReservationStatus, Integer> {
	@Query("SELECT r FROM ReservationStatus r WHERE r.checkInDate BETWEEN ?1 and ?2 OR r.checkOutDate BETWEEN ?1 and ?2 OR r.checkInDate >= ?1 AND r.checkOutDate <= ?2")
	public List<ReservationStatus> getRoomReservations(LocalDate checkIn,LocalDate checkOut);
	
	@Query("SELECT r FROM Room r left join fetch r.roomCategory WHERE r.roomId not in (:bookedRooms)")
	public List<Room> getAvailableRooms(List<Integer> bookedRooms);
}
