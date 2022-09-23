package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoomCategoryRepo;
import com.app.entities.RoomCategory;

@Service
@Transactional
public class RoomCategoryServiceImpl implements IRoomCategoryService {
	
	@Autowired
	private IRoomCategoryRepo roomCatRepo;
	@Override
	public RoomCategory getRoomCategory(int id) {
		// TODO Auto-generated method stub
		return roomCatRepo.getFromId(id);
	}

}
