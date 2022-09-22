package com.app.services;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Room;

public interface IReservationStatusService {
	
	public void getRoomReservations(LocalDate checkIn,LocalDate checkOut);
	
	public List<Room> getAvailableRooms();
}
