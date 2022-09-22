package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Status;

@Repository
public interface IStatusRepo extends JpaRepository<Status,Integer> {
	@Query("select s from Status s where status.id=?1")
	public Status getFromId(int id);
}
