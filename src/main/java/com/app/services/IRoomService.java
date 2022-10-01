package com.app.services;

import java.util.List;

import com.app.dto.CheckRoomDTO;
import com.app.dto.RoomActualDTO;
import com.app.dto.RoomDTO;
import com.app.entities.Room;

public interface IRoomService {
	public List<Room> getAllRooms();
	
	public Room addRoom(RoomDTO room);
	
	public RoomActualDTO getRoomInfo(int id);
	
	public Room updateRoom(RoomDTO room);
	
	public List<Room> getAvailableRooms(CheckRoomDTO checkDTO);
	
	public List<Room> getAvailableForAllCat(List<Room> rooms,CheckRoomDTO checkDTO);
	
	public List<Room> getAvailbleForSpecificCatAndSort(List<Room> rooms,CheckRoomDTO checkDTO);
	
	public Room getRoomDetails(int id);
}
