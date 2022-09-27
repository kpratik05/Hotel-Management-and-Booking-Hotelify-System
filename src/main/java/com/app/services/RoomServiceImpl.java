package com.app.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoomRepo;
import com.app.dto.CheckRoomDTO;
import com.app.dto.RoomActualDTO;
import com.app.dto.RoomDTO;
import com.app.entities.Room;
import com.app.sorting.ReverseSortByPrice;
import com.app.sorting.SortByPrice;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomRepo roomRepo;
	@Autowired
	private IRoomCategoryService roomCatService;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IReservationStatusService rService;
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


	@Override
	public List<Room> getAvailableRooms(CheckRoomDTO checkDTO) {
		rService.getRoomReservations(checkDTO.getCheckInDate(), checkDTO.getCheckOutDate());
		List<Room> rooms = rService.getAvailableRooms();
		
		if(checkDTO.getRoomType()==1)
		{
			return getAvailableForAllCat(rooms,checkDTO);
		}
		return getAvailbleForSpecificCatAndSort(rooms, checkDTO);
	}


	@Override
	public List<Room> getAvailableForAllCat(List<Room> rooms,CheckRoomDTO checkDTO) {
		if(checkDTO.getSort()==1)
		{
			Collections.sort(rooms,new SortByPrice());
			return rooms;
		}
		Collections.sort(rooms,new ReverseSortByPrice());
		return rooms;
	}


	@Override
	public List<Room> getAvailbleForSpecificCatAndSort(List<Room> rooms,CheckRoomDTO checkDTO) {
		List<Room> r = new ArrayList<Room>();
		for(Room rm : rooms)
		{
			if(rm.getRoomCategory().getCatId()==checkDTO.getRoomType())
			{
				r.add(rm);
			}
		}
		if(checkDTO.getSort()==1)
		{
			Collections.sort(r,new SortByPrice());
		}
		else {
		Collections.sort(r,new ReverseSortByPrice());
		}
		return r;
	}

}
