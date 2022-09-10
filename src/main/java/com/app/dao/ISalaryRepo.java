package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Salary;

@Repository
public interface ISalaryRepo extends JpaRepository<Salary, Integer> {

}
