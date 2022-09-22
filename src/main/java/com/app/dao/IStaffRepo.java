package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Staff;

@Repository
public interface IStaffRepo extends JpaRepository<Staff, Integer> {
	@Query("select s from Staff s left join fetch s.department left join fetch s.shift left join fetch s.role where s.employeeId=?1")
	public Staff getFromId(int id);
	
}
