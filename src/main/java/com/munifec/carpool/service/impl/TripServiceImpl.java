package com.munifec.carpool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.munifec.carpool.model.Trip;
import com.munifec.carpool.repository.TripRepository;
import com.munifec.carpool.service.TripService;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	TripRepository tripRepository;

	@Override
	public List<Trip> getTripList(Pageable pageable) {
		return  tripRepository.findAll(pageable);
	}

	@Override
	public Trip getTripListById(long id) {
		return tripRepository.findById(id).get();
	}

	@Override
	public Trip saveTrip(Trip trip) {
		return tripRepository.save(trip);
	}

	@Override
	public void deleteTrip(Trip trip) {
		tripRepository.delete(trip);
	}

	@Override
	public List<Trip> getTripList() {
		return tripRepository.findAll();
	}

}
