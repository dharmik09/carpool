package com.munifec.carpool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.munifec.carpool.model.TripRequest;

public interface TripRequestService {
	
	public List<TripRequest> getAllTripRequest(Pageable pageable);
	
	public TripRequest saveRequest(TripRequest tripRequest);
	
	public List<TripRequest> listByRequestId(long userId);
	
	public List<TripRequest> getAll();
}
