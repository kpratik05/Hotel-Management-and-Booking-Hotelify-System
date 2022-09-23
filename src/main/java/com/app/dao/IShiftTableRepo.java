package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.ShiftTable;

@Repository
public interface IShiftTableRepo extends JpaRepository<ShiftTable, Integer> {
	@Query("select s from ShiftTable s where s.shiftId=?1")
	public ShiftTable getShift(int shiftId);
	
	@Query("select s from ShiftTable s")
	public List<ShiftTable> getAllShift();
}
