package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.StaffFeedback;

@Repository
public interface IStaffFeedbackRepo extends JpaRepository<StaffFeedback, Integer> {
	
	@Query("select f from StaffFeedback f left join fetch f.staff where f.staff.employeeId=?1")
	public List<StaffFeedback> getFromEmployeeId(int id);
	
	@Query("select f from StaffFeedback f left join fetch f.staff where f.employeeFeedbackId=?1")
	public StaffFeedback getFromId(int id);
	
	@Query("select f from StaffFeedback f left join fetch f.staff where f.staff.department.deptId=?1")
	public List<StaffFeedback> getEmployeeFeedbackFromDept(int dept);
}
