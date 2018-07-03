package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.munifec.carpool.model.Trip;

public interface TripService {
	
	public List<Trip> getTripList(Pageable pageable);
	
	public Trip getTripListById(long id);
	
	public Trip saveTrip(Trip trip);
	
	public void deleteTrip(Trip trip);
	
	public List<Trip> getTripList();
}
