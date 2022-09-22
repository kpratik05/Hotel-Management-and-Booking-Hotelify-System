package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.ShiftTable;

@Repository
public interface IShiftTableRepo extends JpaRepository<ShiftTable, Integer> {
	@Query("select s from ShiftTable s left join fetch s.department where s.shiftId=?1")
	public ShiftTable getShift(int shiftId);
}
