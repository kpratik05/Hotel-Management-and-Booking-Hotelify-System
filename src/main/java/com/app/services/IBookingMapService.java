package com.app.services;

import java.util.Set;

import com.app.entities.BookingMap;

public interface IBookingMapService {
	public BookingMap getBookingMap(int mapId);
	
	public Set<BookingMap> getBookingMapsFromBooking(int bookingId);
	
	public void addBookingMap(BookingMap map);
}
