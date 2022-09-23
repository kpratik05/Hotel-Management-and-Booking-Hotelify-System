package com.app.services;

import java.util.List;

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
	public ShiftTable getFromId(int id) {
		ShiftTable  shift = shiftRepo.getShift(id);
		return shift;
	}
	@Override
	public ShiftTable addShift(ShiftTableDTO shiftDTO) {
		ShiftTable shift = mapper.map(shiftDTO, ShiftTable.class);
		
		return shiftRepo.save(shift);
	}
	@Override
	public ShiftTable updateShift(ShiftTableDTO shiftDTO) {
		System.out.println(shiftDTO);
		ShiftTable shift = mapper.map(shiftDTO, ShiftTable.class);
		return shiftRepo.save(shift);
	}
	@Override
	public List<ShiftTable> getShiftList() {
		// TODO Auto-generated method stub
		return shiftRepo.getAllShift();
	}

}
