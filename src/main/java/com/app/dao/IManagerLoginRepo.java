package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.ManagerLogin;
@Repository
public interface IManagerLoginRepo extends JpaRepository<ManagerLogin, Integer> {
	@Query("select m from ManagerLogin m left join fetch m.manager where m.manager.employeeId=?1")
	public List<ManagerLogin> getLoginManager(int id);
	
	@Query("select m from ManagerLogin m left join fetch m.manager")
	public List<ManagerLogin> getAllLogin();
}
