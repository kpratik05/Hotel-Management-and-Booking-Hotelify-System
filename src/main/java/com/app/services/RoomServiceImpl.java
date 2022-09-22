package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoomRepo;
import com.app.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomRepo roomRepo;
	
	
	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = roomRepo.getAllRooms();
		return rooms;
	}

}
