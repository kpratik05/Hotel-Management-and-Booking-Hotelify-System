package com.app.sorting;

import java.util.Comparator;

import com.app.entities.Room;

public class SortByPrice implements Comparator<Room> {

	@Override
	public int compare(Room r1,Room r2) {
		// TODO Auto-generated method stub
		return ((Double)r1.getUnitPrice()).compareTo(r2.getUnitPrice());
	}

}
