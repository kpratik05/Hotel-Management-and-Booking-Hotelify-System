package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Role;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {
	@Query("select r from Role r where r.roleId=?1")
	public Role getFromId(int id);
}
