package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStaffRepo;
import com.app.dto.StaffActualDTO;
import com.app.entities.Staff;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IStaffRepo staffRepo;
	
	@Override
	public StaffActualDTO getFromEmployeeId(int id) {
		Staff staff = staffRepo.getFromId(id);
		StaffActualDTO staffActual = mapper.map(staff, StaffActualDTO.class);
		return staffActual;
	}

	@Override
	public Staff saveStaff(Staff staff) {
		
		return staffRepo.save(staff);
	}
}
