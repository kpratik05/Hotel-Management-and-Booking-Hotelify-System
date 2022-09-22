package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Integer> {
	@Query("SELECT a FROM Admin a where a.adminId= ?1 and a.password=?2")
	public Admin getAdminDetails(int id,String password);
}
