package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoomRepo;
import com.app.dto.RoomActualDTO;
import com.app.dto.RoomDTO;
import com.app.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomRepo roomRepo;
	@Autowired
	private IRoomCategoryService roomCatService;
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = roomRepo.getAllRooms();
		return rooms;
	}


	@Override
	public Room addRoom(RoomDTO roomDTO) {
		RoomActualDTO roomActual = new RoomActualDTO();
		roomActual.setFloorNum(roomDTO.getFloorNum());
		roomActual.setRoomCategory(roomCatService.getRoomCategory(roomDTO.getRoomCategory()));
		roomActual.setRoomNum(roomDTO.getRoomNum());
		roomActual.setUnitPrice(roomDTO.getUnitPrice());
		Room room = mapper.map(roomActual,Room.class);
		return roomRepo.save(room);
	}


	
	
	@Override
	public Room updateRoom(RoomDTO roomDTO) {
		System.out.println(roomDTO);
		RoomActualDTO roomActual = getRoomInfo(roomDTO.getRoomId());
		roomActual.setFloorNum(roomDTO.getFloorNum());
		roomActual.setRoomCategory(roomCatService.getRoomCategory(roomDTO.getRoomCategory()));
		roomActual.setRoomNum(roomDTO.getRoomNum());
		roomActual.setUnitPrice(roomDTO.getUnitPrice());
		Room room = mapper.map(roomActual,Room.class);
		return roomRepo.save(room);
	}


	@Override
	public RoomActualDTO getRoomInfo(int id) {
		// TODO Auto-generated method stub
		RoomActualDTO roomActual = mapper.map(roomRepo.getRoom(id),RoomActualDTO.class);
		return roomActual;
	}

}
