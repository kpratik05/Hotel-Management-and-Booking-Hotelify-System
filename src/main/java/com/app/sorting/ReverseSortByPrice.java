package com.app.sorting;

import java.util.Comparator;

import com.app.entities.Room;

public class ReverseSortByPrice implements Comparator<Room> {

	@Override
	public int compare(Room r1, Room r2) {
		// TODO Auto-generated method stub
		return ((Double)r2.getUnitPrice()).compareTo(r1.getUnitPrice());
	}

}
