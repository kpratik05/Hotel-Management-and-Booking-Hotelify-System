package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.ShiftTable;

@Repository
public interface IShiftTableRepo extends JpaRepository<ShiftTable, Integer> {

}
