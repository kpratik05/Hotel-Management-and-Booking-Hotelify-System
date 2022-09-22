package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Department;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department, Integer> {
	@Query("select d from Department d where d.deptId=?1")
	public Department getFromId(int id);
}
