package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.ReservationStatus;

@Repository
public interface IReservationStatusRepo extends JpaRepository<ReservationStatus, Integer> {

}
