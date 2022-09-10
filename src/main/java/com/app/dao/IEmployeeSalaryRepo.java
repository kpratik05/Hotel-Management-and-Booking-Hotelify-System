package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.EmployeeSalary;

@Repository
public interface IEmployeeSalaryRepo extends JpaRepository<EmployeeSalary, Integer> {

}
