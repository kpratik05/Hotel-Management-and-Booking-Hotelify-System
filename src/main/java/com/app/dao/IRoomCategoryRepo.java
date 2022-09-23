package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.RoomCategory;

@Repository
public interface IRoomCategoryRepo extends JpaRepository<RoomCategory, Integer> {
	@Query("select r from RoomCategory r where r.catId=?1")
	public RoomCategory getFromId(int id);
}
