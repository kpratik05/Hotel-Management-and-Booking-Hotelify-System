package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.StaffLogin;

@Repository
public interface IStaffLoginRepo extends JpaRepository<StaffLogin, Integer> {
	@Query("select s from StaffLogin s left join fetch s.staff where s.staff.department.deptId=?1")
	public List<StaffLogin> getStaffLoginFromDept(int id);
	
	@Query("select s from StaffLogin s left join fetch s.staff")
	public List<StaffLogin> getStaffLogin();
}
