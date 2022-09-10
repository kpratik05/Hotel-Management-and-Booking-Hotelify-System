package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Manager;

@Repository
public interface IManagerRepo extends JpaRepository<Manager, Integer> {

}
