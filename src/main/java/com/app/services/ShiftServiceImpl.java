package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShiftTableRepo;
import com.app.dto.ShiftTableDTO;
import com.app.entities.ShiftTable;

@Service
@Transactional
public class ShiftServiceImpl implements IShiftService {
	
	@Autowired
	private IShiftTableRepo shiftRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ShiftTableDTO getFromId(int id) {
		ShiftTable  shift = shiftRepo.getShift(id);
		ShiftTableDTO shiftDTO = mapper.map(shift, ShiftTableDTO.class);
		return shiftDTO;
	}

}
