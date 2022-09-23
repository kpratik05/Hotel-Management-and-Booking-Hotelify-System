package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Manager;
import com.app.entities.ManagerLogin;
import com.app.entities.Staff;

@Repository
public interface IManagerRepo extends JpaRepository<Manager, Integer> {
	@Query("SELECT m FROM Manager m left join fetch m.department where m.employeeId=?1 and m.password=?2")
	public Manager findByIdAndPassword(int id,String password);
	
	@Query("select s from Staff s left join fetch s.department left join fetch s.shift left join fetch s.role where s.department.deptId=?1")
	public List<Staff> getEmployeesInDepartment(int deptNo);
	
	@Query("select m from Manager m left join fetch m.department where m.employeeId=?1")
	public Manager getFromId(int id);

}
