package com.app.services;

import java.util.List;

import com.app.entities.ManagerLogin;

public interface IManagerLoginService {
	public List<ManagerLogin> getAllLogin();
	
	public List<ManagerLogin> getManagerLogin(int id);
}
