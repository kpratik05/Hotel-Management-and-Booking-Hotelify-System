package com.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IReservationStatusRepo;
import com.app.entities.ReservationStatus;
import com.app.entities.Room;

@Service
@Transactional
public class ReservationStatusServiceImpl implements IReservationStatusService {
	
	@Autowired
	private IReservationStatusRepo reservationRepo;
	
	
	List<ReservationStatus> bookedRooms = new ArrayList<ReservationStatus>();
	
	@Override
	public void getRoomReservations(LocalDate checkIn, LocalDate checkOut) {
		bookedRooms = (List<ReservationStatus>) reservationRepo.getRoomReservations(checkIn, checkOut);
	}
	
	public List<Room> getAvailableRooms()
	{
		List<Integer> rooms = new ArrayList<Integer>();
		rooms.add(0);
		for(ReservationStatus r : bookedRooms)
		{ 
			rooms.add(r.getRoom().getRoomId());
		} 
		List<Room> availableRooms = reservationRepo.getAvailableRooms(rooms);
		
		return availableRooms;
	}

	@Override
	public void saveReservation(ReservationStatus res) {
		// TODO Auto-generated method stub
		reservationRepo.save(res);
	}
	
	
}
