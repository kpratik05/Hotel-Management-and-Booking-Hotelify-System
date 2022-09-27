package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.ShiftTable;
import com.app.entities.Staff;

@Repository
public interface IStaffRepo extends JpaRepository<Staff, Integer> {
	@Query("select s from Staff s left join fetch s.department left join fetch s.shift left join fetch s.role where s.employeeId=?1")
	public Staff getFromId(int id);
	
	@Query("select s from Staff s left join fetch s.department left join fetch s.shift left join fetch s.role")
	public List<Staff> getStaffList();
	
	@Modifying
	@Query("update Staff s set s.shift = :shift where s.employeeId = :id")
	public void updateShift(@Param("shift") ShiftTable shift,@Param("id") int id);
	
	@Modifying
	@Query("delete from Staff s where s.employeeId=:id")
	void deleteStaffFromId(int id);
}
