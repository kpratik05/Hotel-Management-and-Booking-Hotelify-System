package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Room;

@Repository
public interface IRoomRepo extends JpaRepository<Room, Integer> {

}
