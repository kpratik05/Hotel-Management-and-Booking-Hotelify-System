package com.app.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBookingMapRepo;
import com.app.entities.BookingMap;

@Service
@Transactional
public class BookingMapService implements IBookingMapService{
	
	@Autowired
	private IBookingMapRepo bookingMapRepo;
	
	@Override
	public BookingMap getBookingMap(int mapId) {
		BookingMap bookingMap =  bookingMapRepo.findByMapId(mapId);
		if(bookingMap != null)
		{
			return bookingMap;
		}
		return null;
	}

	@Override
	public Set<BookingMap> getBookingMapsFromBooking(int bookingId) {
		Set<BookingMap> bookingMaps = bookingMapRepo.findByBookingId(bookingId);
		if(!bookingMaps.isEmpty())
		{
			return bookingMaps;
		}
		return null;
	}

	@Override
	public void addBookingMap(BookingMap map) {
		if(map==null)
		{
			return;
		}
		bookingMapRepo.save(map);
	}

}
