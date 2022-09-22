package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Services;

@Repository
public interface IServicesRepo extends JpaRepository<Services, Integer> {
	@Query("SELECT s FROM Services s WHERE s.serviceName=?1")
	public Services getServiceDetails(String serv);
}
