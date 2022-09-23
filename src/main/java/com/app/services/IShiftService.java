package com.app.services;

import java.util.List;

import com.app.dto.ShiftTableDTO;
import com.app.entities.ShiftTable;

public interface IShiftService {
	public List<ShiftTable> getShiftList();
	
	public ShiftTable getFromId(int id);
	
	public ShiftTable addShift(ShiftTableDTO shiftDTO);
	
	public ShiftTable updateShift(ShiftTableDTO shiftDTO);
}
