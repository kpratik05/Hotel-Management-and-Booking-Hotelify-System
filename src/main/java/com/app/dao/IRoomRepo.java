package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Room;

@Repository
public interface IRoomRepo extends JpaRepository<Room, Integer> {
	@Query("select r from Room r left join fetch r.roomCategory")
	public List<Room> getAllRooms();
	
}
