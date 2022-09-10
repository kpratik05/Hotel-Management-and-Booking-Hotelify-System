package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.EmployeeLogin;

@Repository
public interface IEmployeeLoginRepo extends JpaRepository<EmployeeLogin, Integer> {

}
